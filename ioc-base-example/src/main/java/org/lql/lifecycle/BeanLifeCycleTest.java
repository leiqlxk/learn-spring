package org.lql.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Title: BeanLifeCycleTest <br>
 * ProjectName: learn-spring <br>
 * description: bean的生命周期测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 10:42 <br>
 */
public class BeanLifeCycleTest {

    public static void main(String[] args) {

        // 装载配置文件及启动容器
        Resource resource = new ClassPathResource("org/lql/lifecycle/beans.xml");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        // 注册MyBeanPostProcessor后处理器
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        // 注册MyInstantiationAwareBeanPostProcessor后处理器
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
        Car car = (Car) beanFactory.getBean("car");
        car.introduce();
        car.setColor("红色");

        // 第二次从容器中获取car，直接从缓存池中获取
        Car car1 = (Car) beanFactory.getBean("car");

        // 查看car和car1是否指向同一引用
        System.out.println("car == car1:" + (car == car1));

        // 关闭容器
        beanFactory.destroySingletons();

    }
}
