package org.lql.cache.mycache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: CacheManager <br>
 * ProjectName: spring-boot-example <br>
 * description: 自实现缓存管理器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 22:26 <br>
 */
public class CacheManager<T> {

    private Map<String, T> cache = new ConcurrentHashMap<String, T>();

    // 获取记录
    public T getValue(Object key) {
        return cache.get(key);
    }

    // 新增或更新记录
    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    // 根据key删除缓存中的一条记录
    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    // 清空缓存
    public void evictCache() {
        cache.clear();
    }
}
