package org.lql.anno;

import org.springframework.stereotype.Component;

/**
 * Title: UserDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 16:31 <br>
 */

// @Component注解在类声明处对类进行标注，它可以被Spring容器识别，等效于配置文件中的<bean id="userDao" class="org.lql.anno.UserDao"/>
// 除了@Component外Spring还提供了三个功能基本相同的注解，分别对DAO、Service和Web层的Controller进行标注：@Repository、@Service、@Controller
@Component("userDao")
public class UserDao {
}
