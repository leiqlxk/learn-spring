package org.lql.reflect;

/**
 * Title: Car <br>
 * ProjectName: ioc-base-example <br>
 * description: 反射演示实例：java语言允许通过程序化的方式间接对class进行操作，
 * class文件由类装载器装载后，在JVM中将形成一份描述class结构的元信息对象，通过
 * 该元信息对象可以获知class的结构信息如构造函数、属性和方法等。java允许用户借
 * 由这个与class相关的元信息对象的功能。<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 22:24 <br>
 */
public class Car {

    private String brand;

    private String color;

    private int maxSpeed;

    public Car() {
        System.out.println("init car!!");
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce() {
        System.out.println("brand:" + this.brand + ";color:" + this.color + ";maxSpeed:" + this.maxSpeed);
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
}
