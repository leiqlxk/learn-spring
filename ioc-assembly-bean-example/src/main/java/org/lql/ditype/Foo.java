package org.lql.ditype;

/**
 * Title: Foo <br>
 * ProjectName: learn-spring <br>
 * description: 成员变量，变量名约束反例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 13:48 <br>
 */
public class Foo {

    // javaBean约定变量名前两个字母要嘛全大写，要嘛全小写，此变量为非法的，会导致spring根据属性注入时匹配set方法出现失败
    private String iDCode;

    public String getiDCode() {
        return iDCode;
    }

    public void setiDCode(String iDCode) {
        this.iDCode = iDCode;
    }
}
