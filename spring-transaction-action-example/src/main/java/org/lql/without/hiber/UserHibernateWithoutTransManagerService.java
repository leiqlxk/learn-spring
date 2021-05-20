package org.lql.without.hiber;

import org.apache.commons.dbcp.BasicDataSource;
import org.lql.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 * Title: UserHibernateWithoutTransManagerService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 13:56 <br>
 */
@Service("hiberService")
public class UserHibernateWithoutTransManagerService {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void addScore(String userName, int toAdd) {
        User user = hibernateTemplate.get(User.class, userName);

        // 以下两句取消注释后，由于默认事务管理器不支持数据更新，将报异常
        // hibernate的事务管理拥有其自身的意义，它和Hibernate一级缓存存在密切的关系：在调用Session的save、update等方法时，Hibernate并不直接向数据库发送SQL语句，
        // 只在提交事务或flush一级缓存时才真正向数据库发送SQL语句。所以即使底层不支持事务，Hibernate的事务管理也是有一定好处的，不会对数据库操作的效率造成负面影响
        // 如果使用Hibernate数据库访问技术，则没理由不配置HibernateTransactionManager事务管理器。
        // 但是，如果不使用Hibernate事务管理器，Spring就会采用默认的事务管理策略（propagation_required, readOnly）。如果有修改操作是不允许的。
        user.setScore(user.getScore() + toAdd);
        hibernateTemplate.update(user);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("org/lql/without/hiber/hibernateWithoutTx.xml");

        UserHibernateWithoutTransManagerService service = (UserHibernateWithoutTransManagerService) ctx.getBean("hiberService");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();

        // 检查数据源autoCommit的设置
        System.out.println("autoCommit:" + basicDataSource.getDefaultAutoCommit());

        // 插入一条记录
        jdbcTemplate.execute("INSERT INTO t_user(user_name, password, score) " +
                "VALUES('tom', '123456', 10)");

        // 调用工作在无事务环境下的服务类方法，将分数添加20分
        service.addScore("tom", 20);

        // 查看此时用户的分数
        int score = jdbcTemplate.queryForObject("SELECT score FROM t_user WHERE user_name = 'tom'", Integer.class);
        System.out.println("score:" + score);

        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name = 'tom'");
    }
}
