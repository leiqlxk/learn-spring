package org.lql.ditype;

/**
 * Title: Car <br>
 * ProjectName: learn-spring <br>
 * description: 属性和构造函数注入演示实例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 13:27 <br>
 */
public class Car {

    private String brand;

    private String crop;

    private double price;

    private int maxSpeed;

    private Boss boss;

    public Car() {}

    public Car(String brand, Boss boss) {
        this.brand = brand;
        this.boss = boss;
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Car(String brand, String crop, double price) {
        this.brand = brand;
        this.crop = crop;
        this.price = price;
    }

    public Car(String brand, String crop, int maxSpeed) {
        this.brand = brand;
        this.crop = crop;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "brand:" + this.brand + "/maxSpeed:" + this.maxSpeed + "/price:" + this.price;
    }


}
