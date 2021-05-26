package org.lql.cache.cachegroup;

import org.lql.cache.domain.User;

/**
 * Title: Visitor <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 13:31 <br>
 */
public class Visitor extends User {
    protected Visitor(String id, String name) {
        super(id, name);
    }
}
