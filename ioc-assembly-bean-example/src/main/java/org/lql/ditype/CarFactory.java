package org.lql.ditype;

/**
 * Title: CarFactory <br>
 * ProjectName: learn-spring <br>
 * description: 工厂方法注入 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 16:43 <br>
 */
public class CarFactory {

    // 非静态工厂注入
    public Car createHongQiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");

        return car;
    }

    // 静态工厂方法
    public static Car createCar() {
        Car car = new Car();

        return car;
    }
}
