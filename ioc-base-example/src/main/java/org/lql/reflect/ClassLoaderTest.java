package org.lql.reflect;

/**
 * Title: ClassLoaderTest <br>
 * ProjectName: ioc-base-example <br>
 * description: 类装载器测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 23:00 <br>
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        // 默认情况下使用AppClassLoader，父级为ExtClassLoader，祖父级为根装载器，因为根装载器是C++写的并发ClassLoader的子类，因此在java中访问不到为null
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + classLoader);
        System.out.println("parent loader:" + classLoader.getParent());
        System.out.println("grandparent loader:" + classLoader.getParent().getParent());
    }
}
