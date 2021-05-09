package org.lql.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: AppConf <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:00 <br>
 */
// 将一个POJO标注为定义Bean的配置类
@Configuration
public class AppConf {

    // 定义Bean并提供了Bean的实例化逻辑，Bean的名默认和方法名相同，也可以通过入参显式指定
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

    // 定义了logonService的Bean
    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();

        // 将上面定义的两个Bean注入logonService Bean中
        logonService.setLogDao(logDao());
        logonService.setUserDao(userDao());

        return logonService;
    }
}
