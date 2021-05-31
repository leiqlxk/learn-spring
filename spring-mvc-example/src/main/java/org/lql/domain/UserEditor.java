package org.lql.domain;

import java.beans.PropertyEditorSupport;

/**
 * Title: UserEditor <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/31 13:17 <br>
 */
public class UserEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        if (text != null) {
            String[] items = text.split(":");
            user.setUserName(items[0]+"by propertyeEditor");
            user.setPassword(items[1]);
            user.setRealName(items[2]);
        }
        setValue(user);
    }
}
