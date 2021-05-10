package org.lql.placeholder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Title: MyDataSource <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 11:39 <br>
 */
@Component
public class MyDataSource {

    // 通过@Value注解为Bean的成员变量或方法入参注入容器已有属性
    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
