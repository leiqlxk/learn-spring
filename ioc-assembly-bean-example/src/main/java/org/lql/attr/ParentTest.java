package org.lql.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: ParentTest <br>
 * ProjectName: learn-spring <br>
 * description: 引用父容器实例演示 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 17:29 <br>
 */
public class ParentTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[]{"org/lql/attr/beans1.xml"});

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"org/lql/attr/beans2.xml"}, pFactory);

        Boss boss = (Boss) applicationContext.getBean("boss");
        System.out.println(boss.getCar().toString());
    }
}
