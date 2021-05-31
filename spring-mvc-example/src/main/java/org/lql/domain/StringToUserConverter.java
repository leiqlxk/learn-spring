package org.lql.domain;

import org.springframework.core.convert.converter.Converter;

/**
 * Title: StringToUserConverter <br>
 * ProjectName: learn-spring <br>
 * description: 自定义类型转换器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/31 11:42 <br>
 */
public class StringToUserConverter implements Converter<String, User> {

    public User convert(String s) {
        User user = new User();
        if(s != null){
            String[] items = s.split(":");
            user.setUserName(items[0]);
            user.setPassword(items[1]);
            user.setRealName(items[2]);
        }
        return user;
    }
}
