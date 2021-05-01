package org.lql.context;

import jdk.nashorn.internal.runtime.RewriteException;
import org.lql.beanfactory.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: Beans <br>
 * ProjectName: spring-boot-example <br>
 * description: 基于类注解的配置方式 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/1 23:05 <br>
 */
// 表示是一个配置信息提供类
@Configuration
public class Beans {

    // 定义一个Bean
    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗C72");
        car.setMaxSpeed(200);
        return car;
    }
}
