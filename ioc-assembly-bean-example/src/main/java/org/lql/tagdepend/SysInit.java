package org.lql.tagdepend;

/**
 * Title: SysInit <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 23:00 <br>
 */
public class SysInit {

    public SysInit() {
        //模拟从数据库中加载系统参数设置值
        SystemSettings.SESSION_TIMEOUT = 10;
        SystemSettings.REFRESH_CYCLE = 100;
    }
}
