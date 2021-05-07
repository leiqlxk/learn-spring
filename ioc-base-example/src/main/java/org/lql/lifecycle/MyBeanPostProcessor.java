package org.lql.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Title: MyBeanPostProcessor <br>
 * ProjectName: learn-spring <br>
 * description: BeanPostProcessor后处理实现类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 10:37 <br>
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(s.equals("car")){
            Car car = (Car)o;
            if(car.getMaxSpeed() >= 200){
                System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(s.equals("car")){
            Car car = (Car)o;
            if(car.getColor() == null){
                System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return o;
    }
}
