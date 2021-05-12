package org.lql.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Title: BeanSelfProxyAwareMounter <br>
 * ProjectName: learn-spring <br>
 * description: 注入装配器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 14:51 <br>
 */
@Component
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext applicationContext;

    // 注入spring容器
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // 实现系统启动接口中的装配就绪方法
    public void onReady() {
        // 从容器中获取所有注入的自动代理Bean
        Map<String, BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);

        if (proxyAwareMap != null) {
            for (BeanSelfProxyAware beanSelfProxyAware : proxyAwareMap.values()) {
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                if (logger.isDebugEnabled()) {
                    logger.debug("{}注册自身被代理的实例。");
                }
            }
        }
    }

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
