package org.lql.ioc;

/**
 * Title: ActorArrangable <br>
 * ProjectName: ioc-base-example <br>
 * description: 安排演员接口 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 22:10 <br>
 */
public interface ActorArrangable {
    // 接口注入，将调用类所有依赖注入的方法抽取到一个接口中，调用类通过实现该接口提供相应的注入方法。
    void injectGeli(GeLi geLi);
}
