package org.lql.reflect;

/**
 * Title: PrivateCar <br>
 * ProjectName: ioc-base-example <br>
 * description: 演示反射取消java语言访问检查以访问私有变量 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 23:25 <br>
 */
public class PrivateCar {

    private String color;

    protected void drive() {
        System.out.println("drive private car! the color is:" + this.color);
    }
}
