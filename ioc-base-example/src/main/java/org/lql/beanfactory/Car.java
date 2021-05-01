package org.lql.beanfactory;

import org.springframework.beans.factory.BeanFactory;

/**
 * Title: Car <br>
 * ProjectName: spring-boot-example <br>
 * description: beanfactory演示 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/1 22:12 <br>
 */
public class Car {

    private String brand;

    private String color;

    private int maxSpeed;

    private String name;

    public Car() {
        System.out.println("调用Car()构造函数。");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "brand:" + this.brand + "/color:" + this.color + "/maxSpeed:" + this.maxSpeed;
    }

    public void introduce() {
        System.out.println("introduce:" + this.toString());
    }

    public void myInit() {
        System.out.println("调用myInit()，将maxSpeed设置为240。");
        this.maxSpeed = 240;
    }

    public void myDestory() {
        System.out.println("调用myDestroy()。");
    }
}
