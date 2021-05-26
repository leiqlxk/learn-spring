package org.lql.cache.cacheevict;

import org.lql.cache.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 13:26 <br>
 */
@Service(value = "evictCacheUserService")
public class UserService {
    private Map<Integer, User> users = new HashMap<Integer, User>();

    // 其余Cacheable是反操作，它负责从给定的缓存中移除一个值，默认是在方法调用之后执行
    @CacheEvict("users")
    public void removeUser(int id) {
        users.remove(id);
    }
}
