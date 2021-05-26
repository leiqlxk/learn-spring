package org.lql.cache.mycache;

import org.lql.cache.domain.User;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 11:14 <br>
 */
public class UserService {

    private CacheManager<User> cacheManager;

    public UserService() {
        // 构造一个缓存管理器
        this.cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId) {
        // 首先从缓存中查询
        User user = cacheManager.getValue(userId);
        if (user != null) {
            System.out.println("get from cache..." + userId);

            return user;
        }

        // 否则到数据库中查询
        user = getFromDB(userId);
        if (user != null) {
            cacheManager.addOrUpdateCache(userId, user);
        }

        return user;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("get from DB..." + userId);

        return new User(userId);
    }
}
