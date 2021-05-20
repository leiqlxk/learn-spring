package org.lql.mixdao;

import org.apache.commons.dbcp.BasicDataSource;
import org.lql.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: 混合使用orm和jdbc <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 16:02 <br>
 */
@Service("userService")
public class UserService extends BaseService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private ScoreService scoreService;

    // 该方法嵌套调用了本类的其他方法及其他服务类的方法
    public void logon(String userName) {
        // 通过hibernate访问数据库
        System.out.println("before userService.updateLastLogonTime...");
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime...");

        // 通过jdbc技术访问数据库
        System.out.println("before scoreService.addScore...");
        scoreService.addScore(userName, 20);
        System.out.println("after scoreService.addScore...");
    }

    public void updateLastLogonTime(String userName) {
        User user = hibernateTemplate.get(User.class, userName);
        user.setScore(50);
        hibernateTemplate.update(user);

        // 此句很重要，其将session中的缓存同步到数据库中，之所以要显示调用flush是因为某人情况下，hibernate对数据的更改只记录在一级缓存中，要等到事务提交或显示调用flush
        // 方法时才会将一级缓存中的数据同步到数据库中，而提交事务的操作发生在logon()方法返回前。如果所有针对数据库的更改操作都使用Hibernate，那么这种数据同步的延迟机制
        // 并不会产生任何问题。但是同时采用了不同的数据库访问技术，其他数据库访问技术无法感知到Hibernate的一级缓存。
        hibernateTemplate.flush();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("org/lql/nestcall/applicationContext.xml");

        UserService service = (UserService) ctx.getBean("userService");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        //插入一条记录，初始分数为10
        jdbcTemplate.update("INSERT INTO t_user(user_name,password,score,last_visit) VALUES(?, ?, ?, ?)", new Object[] {"tom", "123456", 10, new Date()});

        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon method...");
        service.logon("tom");
        System.out.println("after userService.logon method...");

//        throw new RuntimeException("");
//        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}
