package org.lql.aspectj.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Title: PreGreetingAspect <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 16:31 <br>
 */
// 通过该注解将PreGreetingAspect标识为一个切面
@Aspect
public class PreGreetingAspect {

    // 定义切点和增强类型
    @Before("execution(* greetTo(..))")
    // 增强横切逻辑
    public void beforeGreeting() {
        System.out.println("How are you");
    }
}
