package org.lql.ioc;

/**
 * Title: LiuDeHua <br>
 * ProjectName: ioc-base-example <br>
 * description: 刘德华-演员实例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 21:48 <br>
 */
public class LiuDeHua implements GeLi {

    @Override
    public void responseAsk(String saying) {
        System.out.println(saying);
    }
}
