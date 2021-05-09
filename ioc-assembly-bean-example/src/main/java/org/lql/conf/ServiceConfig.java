package org.lql.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Title: ServiceConfig <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:10 <br>
 */
@Configuration
// 可以只用Import注解直接导入其他配置类，这样就可以无需通过编码的方式注册多个配置类
@Import(DaoConfig.class)
public class ServiceConfig {

    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();

        // 像调用普通bean一样调用
        logonService.setUserDao(daoConfig.userDao());
        logonService.setLogDao(daoConfig.logDao());

        return logonService;
    }
}
