package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;

/**
 * Title: Application <br>
 * ProjectName: spring-boot-example <br>
 * description: 启动类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/28 22:27 <br>
 */
// @Configuration 定义该类为配置类
// @ComponentScan 开启组件扫描
// @EnableAutoConfiguration 启动自动化配置
@SpringBootApplication
// 启用注解事务管理
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    // 自定义事务管理器
    /*@Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
