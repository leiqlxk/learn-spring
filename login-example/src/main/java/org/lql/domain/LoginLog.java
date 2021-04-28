package org.lql.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Title: LoginLog <br>
 * ProjectName: learn-spring <br>
 * description: 登录日志 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/28 12:53 <br>
 */
public class LoginLog implements Serializable {

    private Integer loginLogId;

    private Integer userId;

    private String ip;

    private Date loginDate;

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
