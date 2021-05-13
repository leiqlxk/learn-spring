package org.lql.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title: NeedTest <br>
 * ProjectName: learn-spring <br>
 * description: @interface-修饰定义注解类，如果成员只有一个时，必须命名为value()，使用时可以忽略value=直接使用@NeedTest(true)，当成员有多个，但使用时仅对value进行赋值，则页可以省略
 * 成员声明限制：
 *      成员以无入参、无抛出异常的方式声明
 *      可以通过default为成员指定一个默认值
 *      成员类型是受限的，合法的类型包括原始数据类型及其封装类、String、Class、enums、注解类型、以及上述类型的数组类型
 * Retention-注解的保留期限：
 *      SOURCE：注解信息仅保留在目标类代码的源文件中，但对应的字节码文件将不再保留
 *      CLASS：注解信息将进入目标类代码的字节码文件中，但类加载器加载字节码文件时不会将注解加载到jvm中，即运行期不能获取注解信息
 *      RUNTIME：注解信息在目标类加载到JVM后依然保留，在运行期可以通过反射机制读取类中的注解
 * Target-注解使用范围
 *      TYPE：类、接口、注解类、Enum声明处，相应的注解称为类型注解
 *      FIELD：类成员变量或常量声明处，相应的注解称为域值注解
 *      METHOD：方法声明处，相应的注解称为方法注解
 *      PARAMETER：参数声明处，相应的注解称为参数注解
 *      CONSTRUCTOR：构造函数声明处，相应的注解称为构造函数注解
 *      LOCAL_VARIABLE：局部变量声明处，相应的注解称为局部变量注解
 *      ANNOTATION_TYPE：注解类声明处，相应的注解称为注解类注解
 *      PACKAGE：包声明处，相应的注解称为包注解<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 10:27 <br>
 */
// 声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
// 声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
// 定义注解
public @interface NeedTest {

    // 声明注解成员
    boolean value() default true;
}
