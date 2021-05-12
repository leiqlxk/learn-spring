package org.lql.aop;

import org.springframework.core.Ordered;

/**
 * Title: SystemBootAddon <br>
 * ProjectName: learn-spring <br>
 * description: 注入装配器接口 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 14:49 <br>
 */
public interface SystemBootAddon extends Ordered {

    // 在系统就绪后调用的方法
    void onReady();
}
