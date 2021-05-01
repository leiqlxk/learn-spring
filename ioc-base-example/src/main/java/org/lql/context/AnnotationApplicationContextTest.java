package org.lql.context;

import org.lql.beanfactory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Title: AnnotationApplicationContextTest <br>
 * ProjectName: spring-boot-example <br>
 * description: 基于注解类的ApplicationContext实现类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/1 23:08 <br>
 */
public class AnnotationApplicationContextTest {

    public static void main(String[] args) {
        // 通过一个带@Configuration的POJO装载Bean配置
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car car = context.getBean("car", Car.class);
        car.introduce();
    }
}
