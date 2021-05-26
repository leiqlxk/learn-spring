package org.lql.cache.cacheput;

import org.lql.cache.domain.User;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CachePut;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 13:20 <br>
 */
@Service(value = "cachePutUserServcie")
public class UserService {

    // 当希望使用方法返回值来更新缓存时使用，不能再同一个方法上同时使用Cacheable和CachePut
    @CachePut(cacheName = "users")
    public User getUserById(int id) {
        System.out.println("User with id " + id + " requested.");
        return getFromDB(id);
    }

    private User getFromDB(int id) {
        System.out.println("get from db...");
        return new User("00001001");
    }
}
