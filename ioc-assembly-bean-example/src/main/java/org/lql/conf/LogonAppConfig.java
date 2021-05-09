package org.lql.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Title: LogonAppConfig <br>
 * ProjectName: spring-boot-example <br>
 * description: Configuration中同样可以引用xml里配置的类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:33 <br>
 */
@Configuration
// 通过ImportResource引入XML配置文件
@ImportResource("classpath:org/lql/conf/beans.xml")
public class LogonAppConfig {

    @Bean
    // 自动注入XML文件中定义的Bean
    @Autowired
    public LogonService logonService(UserDao userDao, LogDao logDao) {
        LogonService logonService = new LogonService();

        logonService.setLogDao(logDao);
        logonService.setUserDao(userDao);

        return logonService;
    }
}
