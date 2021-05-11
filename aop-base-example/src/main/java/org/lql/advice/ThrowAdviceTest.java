package org.lql.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: ThrowAdviceTest <br>
 * ProjectName: spring-boot-example <br>
 * description: 异常排除增强测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:29 <br>
 */
public class ThrowAdviceTest {

    public static void main(String[] args) throws Exception {
        // spring容器方式
        String classPath = "org/lql/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(classPath);

        ForumService forumService = (ForumService) ctx.getBean("forumService");
       try {
           forumService.removeForum(12);
       }catch (Exception e) {
           System.out.println();
       }

       try {
           forumService.updateForum(new Forum());
       }catch (Exception e) {
           System.out.println();
       }

    }
}
