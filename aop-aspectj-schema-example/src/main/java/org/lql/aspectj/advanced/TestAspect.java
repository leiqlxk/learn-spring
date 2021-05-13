package org.lql.aspectj.advanced;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Title: TestAspect <br>
 * ProjectName: spring-boot-example <br>
 * description: 切点复合运算 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:39 <br>
 */
@Aspect
public class TestAspect {
    //-------------复合运算----------
//	@Before("!target(org.lql.NaiveWaiter) "+
//			"&& execution(* serveTo(..)))")
//	public void notServeInNaiveWaiter() {
//		System.out.println("--notServeInNaiveWaiter() executed!--");
//	}
//	@After("within(org.lql.*) "
//			+ " && execution(* greetTo(..)))")
//	public void greeToFun() {
//		System.out.println("--greeToFun() executed!--");
//	}
//
//	@AfterReturning("target(org.lql.Waiter) || "+
//			        " target(org.lql.Seller)")
//	public void waiterOrSeller(){
//		System.out.println("--waiterOrSeller() executed!--");
//	}

    //	//------------引用命名切点----------//
//	@Before("TestNamePointcut.inPkgGreetTo()")
//	public void pkgGreetTo(){
//		System.out.println("--pkgGreetTo() executed!--");
//	}
//
//	@Before("!target(org.lql.NaiveWaiter) && "
//			+"TestNamePointcut.inPkgGreetTo()")
//	public void pkgGreetToNotNaiveWaiter(){
//		System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
//	}
//
    //------------访问连接点对象----------//
    @Around("execution(* greetTo(..)) && target(org.lql.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("------joinPointAccess-------");
        System.out.println("args[0]:"+pjp.getArgs()[0]);
        System.out.println("signature:"+pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("-------joinPointAccess-------");
    }
//
//  //------------绑定连接点参数----------//
//	@Before("target(org.lql.NaiveWaiter) && args(name,num,..)")
//	public void bindJoinPointParams(int num,String name){
//	   System.out.println("----bindJoinPointParams()----");
//	   System.out.println("name:"+name);
//	   System.out.println("num:"+num);
//	   System.out.println("----bindJoinPointParams()----");
//	}

    //------------绑定代理对象----------//
//	@Before("execution(* greetTo(..)) && this(waiter)")
//	@Before("this(waiter)")
//	public void bindProxyObj(Waiter waiter){
//	   System.out.println("----bindProxyObj()----");
//	   System.out.println(waiter.getClass().getName());
//	   System.out.println("----bindProxyObj()----");
//	}

    //------------绑定类标注对象----------//
//	@Before("@within(m)")
//	public void bindTypeAnnoObject(Monitorable m){
//	   System.out.println("----bindTypeAnnoObject()----");
//	   System.out.println(m.getClass().getName());
//	   System.out.println("----bindTypeAnnoObject()----");
//	}
    //------------绑定抛出的异常----------//
//	@AfterReturning(value="target(org.lql.SmartSeller)",returning="retVal")
//	public void bingReturnValue(int retVal){
//	   System.out.println("----bingReturnValue()----");
//	   System.out.println("returnValue:"+retVal);
//	   System.out.println("----bingReturnValue()----");
//	}

//    //------------绑定抛出的异常----------//
//	@AfterThrowing(value="target(org.lql.SmartSeller)",throwing="iae")
//	public void bindException(IllegalArgumentException iae){
//	   System.out.println("----bindException()----");
//	   System.out.println("exception:"+iae.getMessage());
//	   System.out.println("----bindException()----");
//	}
}
