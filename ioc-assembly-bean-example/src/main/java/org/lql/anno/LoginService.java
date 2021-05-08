package org.lql.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Title: LoginService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 17:06 <br>
 */
// 定义一个service的Bean
@Service
public class LoginService {

    // 分别注入LoginDao及UserDao的Bean，Autowired默认按类型（byType）匹配方式在容器中查找匹配的Bean，当且仅当有一个匹配的Bean时，Spring将其注入Autowired标注的变量中
    @Autowired
    // 标注了Lazy及Autowired注解的类在容器启动时不会立即注入属性值，而是延迟到调用该属性的时候才会注入属性值
    @Lazy
    private LoginDao loginDao;

    // 使用Autowired的required属性使得在容器中没有一个和标注变量类型匹配的Bean时也不报错，默认情况下为true会抛出NoSuchBeanDefinitionException异常
    // 使用Qualifier注解可以限定Bean的名称
    @Autowired(required = false)
    @Qualifier("userDao")
    private UserDao userDao;

    // 当Autowired标注在集合类的变量或方法入参时，spring会将容器中类型匹配的所有Bean都自动注入进来
    @Autowired(required = false)
    private List<Plugin> plugins;

    @Autowired
    private Map<String, Plugin> pluginMaps;

    // Autowired同样也可以使用在类方法上，自动将Bean传给方法的入参
    /*@Autowired
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Autowired(required = false)
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    // Qualifier还可以使用再入参上
    /*@Autowired
    public void init(@Qualifier("userDao")UserDao userDao,LogDao logDao){
        System.out.println("multi param inject");
        this.userDao = userDao;
        this.logDao =logDao;
    }*/
}
