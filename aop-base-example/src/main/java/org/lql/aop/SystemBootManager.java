package org.lql.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Title: SystemBootManager <br>
 * ProjectName: learn-spring <br>
 * description: 启动管理器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 15:00 <br>
 */
@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<SystemBootAddon> systemBootAddons = Collections.EMPTY_LIST;

    private boolean hasRunOnce = false;

    // 注入所有SystemBootAddon插件
    @Autowired(required = false)
    public void setSystemBootAddons(List<SystemBootAddon> systemBootAddons) {
        this.systemBootAddons = systemBootAddons;
    }

    // 触发所有插件
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!this.hasRunOnce) {
            for (SystemBootAddon systemBootAddon : this.systemBootAddons) {
                systemBootAddon.onReady();
                if (logger.isDebugEnabled()) {
                    logger.debug("执行插件:{}",systemBootAddon.getClass().getCanonicalName());
                }
            }
            hasRunOnce = true;
        }else {
            if (logger.isDebugEnabled()) {
                logger.debug("已执行过容器启动插件集,本次忽略之.");
            }
        }
    }
}
