package org.lql.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Title: BeanFactoryTest <br>
 * ProjectName: spring-boot-example <br>
 * description: 通过XmlBeanDefinitionReader、DefaultListableBeanFactory实现类启动Spring IoC容器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/1 22:20 <br>
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:org/lql/beanfactory/beans.xml");
        System.out.println(resource.getURL());

        // 被废弃，不建议使用
//        BeanFactory bf = new XmlBeanFactory(resource);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        System.out.println("init BeanFactory.");

        Car car = factory.getBean("car", Car.class);
        System.out.println("car bean is ready for use!");
        car.introduce();
    }
}
