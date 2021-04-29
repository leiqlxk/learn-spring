package org.lql.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Title: PrivateCarReflect <br>
 * ProjectName: ioc-base-example <br>
 * description: 取消java访问检查演示 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 23:28 <br>
 */
public class PrivateCarReflect {

    public static void main(String[] args) throws Throwable {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("org.lql.reflect.PrivateCar");

        PrivateCar privateCar = (PrivateCar) clazz.newInstance();
        Field color = clazz.getDeclaredField("color");

        color.setAccessible(true);
        color.set(privateCar, "红色");

        Method driver = clazz.getDeclaredMethod("drive", (Class[]) null);
        driver.setAccessible(true);
        driver.invoke(privateCar);
    }
}
