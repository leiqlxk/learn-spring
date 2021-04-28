package org.lql.web;

/**
 * Title: LoginCommand <br>
 * ProjectName: learn-spring <br>
 * description: 登陆实体类<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/28 14:47 <br>
 */
public class LoginCommand {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
