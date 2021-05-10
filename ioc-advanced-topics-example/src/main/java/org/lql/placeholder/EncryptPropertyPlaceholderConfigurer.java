package org.lql.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Title: EncryptPropertyPlaceholderConfigurer <br>
 * ProjectName: learn-spring <br>
 * description: 自定义属性占位符配置器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 11:40 <br>
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private String[] encryptPropNames ={"userName","password"};


    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        }else {
            return propertyValue;
        }
    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }

        return false;
    }


}
