package org.lql.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Title: Car <br>
 * ProjectName: learn-spring <br>
 * description: 生命周期展示实例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 10:16 <br>
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;

    private String color;

    private int maxSpeed;

    private BeanFactory beanFactory;

    private String beanName;

    public Car() {
        System.out.println("调用Car的构造函数");
    }

    @Override
    public String toString() {
        return "brand:" + this.brand + "/color:" + this.color + "/maxSpeed:" + this.maxSpeed;
    }

    public void introduce() {
        System.out.println("introduce:" + this.toString());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand方法");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware的setBeanFactory方法");
        this.beanFactory = beanFactory;
    }

    // BeanNameAware接口方法
    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware的setBeanName方法");
        this.beanName = s;
    }

    // DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()");
    }

    // InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240");
        this.maxSpeed = 240;
    }

    // 通过<bean>的destory-method属性指定的销毁方法
    public void myDestory() {
        System.out.println("调用destory-method所指定的myDestory()");
    }
}
