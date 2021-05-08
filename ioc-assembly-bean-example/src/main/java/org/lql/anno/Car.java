package org.lql.anno;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Title: Car <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 17:47 <br>
 */
// 使用Scope注解定义作用域
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class Car {

    private int maxSpeed;
    public String brand;
    private double price;


    public static  String  HONG_QI = "红旗";
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price;
    }

}
