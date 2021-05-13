package org.lql.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Title: TestNamePointcut <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:47 <br>
 */
public class TestNamePointcut {

    // 通过注解方法inPackage()对该切点进行命名，方法可视域修饰符为private，表明改命名切点只能在本切面类中使用
    @Pointcut("within(org.lql.*)")
    private void inPackage() {}

    // protected表明该命名切点可以再当前包中的切面类、子切面类中使用
    @Pointcut("execution(* greetTo(..))")
    protected void greetTo() {}

    // 引用命名切点定义的切点，本切点也是命名切点，其为public
    @Pointcut("inPackage() and greetTo()")
    public void inPkgGreetTo(){}
}
