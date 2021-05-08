package org.lql.impt;

import org.lql.ditype.Boss;
import org.lql.ditype.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: ImportTest <br>
 * ProjectName: learn-spring <br>
 * description: 合并配置文件测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 13:44 <br>
 */
public class ImportTest {

    public static void main(String[] args) {

        // 通过传入数组的方式合并配置文件
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"org/lql/impt/beans1.xml", "org/lql/impt/beans2.xml"});

        // 通过配置文件中使用<import>标签来合并配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/lql/impt/beans2.xml");

        Car car = applicationContext.getBean("car1", Car.class);
        System.out.println(car);

        Boss boss = applicationContext.getBean("boss2", Boss.class);
        System.out.println(boss.getCar());
    }
}
