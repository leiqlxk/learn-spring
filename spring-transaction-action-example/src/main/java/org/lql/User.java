package org.lql;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Title: User <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 14:00 <br>
 */
@Entity
@Table(name="t_user")
public class User implements Serializable {

    @Id
    @Column(name = "USER_NAME")
    private String userName;

    private String password;

    private int score;


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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String toString() {
        return (new ReflectionToStringBuilder(this) {
            protected boolean accept(Field f) {
                if(f.getType().isPrimitive() || f.getType() == String.class ){
                    return true;
                }else{
                    return false;
                }
            }
        }).toString();
    }
}
