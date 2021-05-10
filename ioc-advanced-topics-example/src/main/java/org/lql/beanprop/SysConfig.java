package org.lql.beanprop;

import javax.sql.DataSource;

/**
 * Title: SysConfig <br>
 * ProjectName: learn-spring <br>
 * description: 模拟从数据库获取配置信息 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 13:12 <br>
 */
public class SysConfig {

    private int sessionTimeOut;
    private int maxTabPageNum;
    private DataSource dataSource;

    public void initFromDB() {
        // 从数据库中获取属性配置值
        this.sessionTimeOut = 30;
        this.maxTabPageNum = 10;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getSessionTimeOut() {
        return sessionTimeOut;
    }

    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }
}
