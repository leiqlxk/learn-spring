package org.lql.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: Test <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 16:16 <br>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("org/lql/event/beans.xml");

        MailSender mailSender = ctx.getBean("mailSender", MailSender.class);
        mailSender.sendMail("aaa@bbb.com");
    }
}
