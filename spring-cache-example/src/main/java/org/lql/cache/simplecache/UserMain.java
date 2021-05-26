package org.lql.cache.simplecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: UserMain <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 11:37 <br>
 */
public class UserMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = ctx.getBean("userServiceBean", UserService.class);

        // 第一次查询，查询数据库
        System.out.println("first query....");
        userService.getUserById("00001001");

        // 第二次查询，查询缓存
        System.out.println("second query....");
        userService.getUserById("00001001");
    }
}
