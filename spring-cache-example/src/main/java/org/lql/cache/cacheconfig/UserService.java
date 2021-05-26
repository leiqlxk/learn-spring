package org.lql.cache.cacheconfig;

import org.lql.cache.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Title: UserService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 13:35 <br>
 */
// CacheConfig注解在类上相当于全局缓存注解，方法注解上就不用在一遍遍重复
@CacheConfig(cacheNames = "users")
public class UserService {

    @Cacheable
    public User findA(User user) {
        return null;
    }

    @Cacheable
    public User findB(User user) {
        return null;
    }
}
