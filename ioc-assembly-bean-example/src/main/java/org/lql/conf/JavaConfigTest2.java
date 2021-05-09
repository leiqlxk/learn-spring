package org.lql.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Title: JavaConfigTest2 <br>
 * ProjectName: spring-boot-example <br>
 * description: 通过编码的方式加载多个配置类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:22 <br>
 */
public class JavaConfigTest2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // 注册多个配置类
        ctx.register(DaoConfig.class);
        ctx.register(ServiceConfig.class);

        // 刷新容器以应用这些注册的配置类
        ctx.refresh();

        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHelllo();
    }
}
