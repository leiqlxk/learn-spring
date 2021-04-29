package org.lql.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Title: ReflectTest <br>
 * ProjectName: ioc-base-example <br>
 * description: 反射调用测试类:几个重要的反射类，ClassLoader、Class、Constructor、Method <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 22:40 <br>
 */
public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {
        //正常情况下创建Car实例
        /*Car car = new Car();
        car.setBrand("红旗CA72");

        Car car1 = new Car("红旗CA72", "黑色", 300);*/

        // 反射实例化过程
        // 1.通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("org.lql.reflect.Car");

        // 2.获取类的默认构造器对象并通过它实例化Car
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        // 3.通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 300);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
