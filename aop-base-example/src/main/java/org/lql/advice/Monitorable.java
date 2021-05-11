package org.lql.advice;

/**
 * Title: Monitorable <br>
 * ProjectName: spring-boot-example <br>
 * description: 是否开启性能监控 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:36 <br>
 */
public interface Monitorable {

    void setMonitorActive(boolean active);
}
