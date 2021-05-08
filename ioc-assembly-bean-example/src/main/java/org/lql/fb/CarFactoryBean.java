package org.lql.fb;

import org.springframework.beans.factory.FactoryBean;

/**
 * Title: CarFactoryBean <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 15:10 <br>
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    // 接收逗号分隔的属性设置信息
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    // 实例化Car bean
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] info = this.carInfo.split(",");
        car.setBrand(info[0]);
        car.setPrice(Double.parseDouble(info[1]));
        car.setMaxSpeed(Integer.parseInt(info[2]));
        return car;
    }

    // 返回Car类型
    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    // 标识通过FactoryBean返回的Bean是否是singleton
    @Override
    public boolean isSingleton() {
        return false;
    }
}
