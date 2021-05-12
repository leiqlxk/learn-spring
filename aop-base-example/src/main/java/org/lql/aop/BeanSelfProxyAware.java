package org.lql.aop;

/**
 * Title: BeanSelfProxyAwar <br>
 * ProjectName: learn-spring <br>
 * description: 注入自身代理类接口 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 14:47 <br>
 */
public interface BeanSelfProxyAware {
    // 织入自身代理类
    void setSelfProxy(Object object);
}
