package org.lql.beanprop;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Title: ApplicationManager <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 13:25 <br>
 */
@Component
public class ApplicationManager {

    // 使用@Value("${}")引用文件中的属性，使用@Value("#{}")引用bean中的属性
    @Value("#{sysConfig.sessionTimeout}")
    private int sessionTimeout;

    @Value("#{sysConfig.maxTabPageNum}")
    private int maxTabPageNum;

    public int getSessionTimeout() {
        return sessionTimeout;
    }
    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }
    public void setMaxTabPageNum(int maxTabPageNum) {
        this.maxTabPageNum = maxTabPageNum;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
