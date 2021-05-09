package org.lql.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Title: JavaConfigTest <br>
 * ProjectName: spring-boot-example <br>
 * description: 直接通过@Configuration类启动Spring容器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:17 <br>
 */
public class JavaConfigTest {

    public static void main(String[] args) {
        // 使用@Configuration类提供的Bean定义信息启动容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConf.class);

        LogonService logonService = applicationContext.getBean(LogonService.class);
        logonService.printHelllo();
    }
}
