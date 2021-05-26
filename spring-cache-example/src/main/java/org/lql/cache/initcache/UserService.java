package org.lql.cache.initcache;

import org.lql.cache.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Uservice <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 13:53 <br>
 */
@Service(value = "initUserService")
public class UserService {

    private Map<Integer, User> userMap = new HashMap<Integer, User>();

    {
        userMap.put(1, new User("1", "w1"));
        userMap.put(2, new User("2", "w2"));
    }

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void setup() {
        Cache cache = cacheManager.getCache("users");
        for (Integer key : userMap.keySet()) {
            cache.put(key, userMap.get(key));
        }
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested.");
        return userMap.get(id);
    }
}
