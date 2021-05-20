package org.lql.multithread;

import org.apache.commons.dbcp.BasicDataSource;
import org.lql.mixdao.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 16:02 <br>
 */
@Service("userService")
public class UserService extends BaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ScoreService scoreService;

    // 该方法嵌套调用了本类的其他方法及其他服务类的方法
    public void logon(String userName) {
        System.out.println("before userService.updateLastLogonTime...");
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime...");

        // 在一个新线程中执行addScore，不同线程中的事务独立工作
        System.out.println("before scoreService.addScore...");
        Thread thread =new MyThread(this.scoreService, userName, 20);
        thread.start();
        System.out.println("after scoreService.addScore...");
    }

    public void updateLastLogonTime(String userName) {
        String sql = "UPDATE t_user u SET u.last_visit = ? WHERE user_name =?";
        jdbcTemplate.update(sql, new Date(), userName);

//        throw new RuntimeException("");
    }

    private class MyThread extends Thread {
        private ScoreService scoreService;
        private String userName;
        private int toAdd;

        private MyThread(ScoreService scoreService, String userName, int toAdd) {
            this.scoreService = scoreService;
            this.userName = userName;
            this.toAdd = toAdd;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("before scoreService.addScor method...");
            scoreService.addScore(userName, toAdd);
            System.out.println("after scoreService.addScor method...");
        }
    }


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("org/lql/multithread/applicationContext.xml");

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
