package org.lql.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

/**
 * Title: TestAspect <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:19 <br>
 */
@Aspect
public class TestAspect implements Ordered {

    // 后置增强切面
    @AfterReturning("@annotation(org.lql.anno.NeedTest)")
    public void needTestFun() {
        System.out.println("needTestFun() executed!");
    }

    //    @Before("execution(public * *(..))")
//	public void allPublicFun(){
//	    System.out.println("allPublicFun() executed!");
//	}
//    @AfterReturning("execution(* *To(..))")
//    public void allToFun(){
//    	System.out.println("allToFun() executed!");
//    }
//    @Before("execution(* org.lql.aspectj.fun.Waiter.*(..))")
//    public void allWaiterFun(){
//    	System.out.println("allWaiterFun() executed!");
//    }
//    @Before("execution(* org.lql.aspectj.fun.Waiter+.*(..))")
//    public void allChildClassFun(){
//    	System.out.println("allChildClassFun() executed!");
//    }
//	@Before("execution(* joke(Object,int)))")
    @Before("args(Object,*)")
    public void jokeFun(){
        System.out.println("jokeFun() executed!");
    }

    //    @AfterReturning("@annotation(com.smart.anno.NeedTest)")
//    public void atAnnotaionTest(){
//    	System.out.println("atAnnotaionTest() executed!");
//    }
//    @AfterReturning("args(String)")
//    public void argsTest(){
//    	System.out.println("argsTest() executed!");
//    }
//    @AfterReturning("@args(Monitorable)")
//    public void atArgsTest(){
//    	System.out.println("atArgsTest() executed!");
//    }
//    @Before("within(org.lql.aspectj.fun.Waiter)")
//    public void withinTest(){
//    	System.out.println("withinTest() executed!");
//    }
//    @Before("@within(org.lql.aspectj.fun.Monitorable)")
//	public void atWithinTest() {
//		System.out.println("atWithinTest() executed!");
//	}
    @AfterReturning("this(org.lql.Seller)")
    public void thisTest(){
        System.out.println("thisTest() executed!");
    }

    public int getOrder() {
        // TODO Auto-generated method stub
        return 1;
    }
}
