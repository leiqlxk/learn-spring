package org.lql.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Title: MyInstantiationAwareBeanPostProcessor <br>
 * ProjectName: learn-spring <br>
 * description: InstantiationAwareBeanPostProcessorAdapter后处理器实现 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 10:31 <br>
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    // 在实例化前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        // 仅针对car做处理
        if ("car".equals(beanName)) {
            System.out.println("执行InstantiactionAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation()");
        }
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    // 在实例化后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // 仅针对car做处理
        if ("car".equals(beanName)) {
            System.out.println("执行InstantiactionAwareBeanPostProcessorAdapter.postProcessAfterInstantiation()");
        }
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    // 在设置属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        // 仅针对car做处理
        if ("car".equals(beanName)) {
            System.out.println("执行InstantiactionAwareBeanPostProcessorAdapter.postProcessPropertyValues()");
        }
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }
}
