package org.lql.conf;

/**
 * Title: LogonService <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/9 22:03 <br>
 */
public class LogonService {

    private LogDao logDao;
    private UserDao userDao;
    public LogDao getLogDao() {
        return logDao;
    }
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printHelllo(){
        System.out.println("hello!");
    }
}
