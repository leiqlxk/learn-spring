package org.lql.dynamic;

/**
 * Title: UserService <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:47 <br>
 */
public class UserService {
    private UserDao  userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
