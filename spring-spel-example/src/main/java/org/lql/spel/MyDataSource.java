package org.lql.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Title: MyDataSource <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/17 11:43 <br>
 */
@Component
public class MyDataSource {

//    @Value("#{properties['driverClassName']}")
    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;
}
