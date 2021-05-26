package org.lql.cache.simplecache;

import org.lql.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 11:26 <br>
 */
@Service(value = "userServiceBean")
public class UserService {

    // 缓存的本质就是键/值对集合，在默认情况下缓存抽象使用方法签名及参数值作为一个键值，并将该键与方法调用的结果组成键值对，如果在Cache注解上没有指定key则spring会使用
    // KeyGenerator来生成一个key，spring默认提供了SimpleKeyGenerator生成器，如果没有入参则使用SimpleKey.Empty作为key，如果一个入参则使用入参作为key，如果有多个入参，则返回包含所有入参的一个SimpleKey
    // 可以通过实现KeyGenerator来实现自定义KeyGenerator
    // @Cache注解：
    //      vlue、cacheNames属性定义缓存名称，cacheNames可以以列表的形式指定多个缓存用逗号隔开
    //      key：指定key值可以使用springEL指定自定义键，如 @Cacheable(cacheNames = "users"， key="#user.userCode")
    //      condition：按条件进行缓存，如 @Cacheable(cacheNames = "users"， key="#user.userCode"， condition="#user.age < 35")
    //      unless：排除某部分，@Cacheable(cacheNames = "users"， key="#user.userCode"， unless="#user.age >= 35")
    @Cacheable(cacheNames = "users")
    public User getUserById(String userId) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        System.out.println("real query user." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        return new User("00001001");
    }
}
