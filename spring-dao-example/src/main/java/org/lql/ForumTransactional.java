package org.lql;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title: ForumTransactional <br>
 * ProjectName: spring-boot-example <br>
 * description: 自定义特定事务注解 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/19 22:39 <br>
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
// 绑定到forum的事务管理器中
@Transactional("forum")
public @interface ForumTransactional {
}
