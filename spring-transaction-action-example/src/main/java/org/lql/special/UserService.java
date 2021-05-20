package org.lql.special;

import org.springframework.stereotype.Service;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: 事务增强遗漏实例,基于CGLib字节码动态代理无法享受Spring AOP事务增强的特殊方法 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 17:28 <br>
 */
@Service("userService")
public class UserService {

    // private方法因访问权限的限制,无法被子类覆盖
    private void method1() {}

    // final方法无法被子类覆盖
    public final void method2() {}

    // static是类级别的方法，无法被子类覆盖
    public static void method3(){}

    // public方法能被子类覆盖，因此可以被动态字节码增强
    public void method4() {}

    // protected方法可以被子类覆盖，因此可以被动态字节码增强
    protected void method5() {}
}
