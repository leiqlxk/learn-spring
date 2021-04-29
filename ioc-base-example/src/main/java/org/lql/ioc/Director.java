package org.lql.ioc;

/**
 * Title: Director <br>
 * ProjectName: ioc-base-example <br>
 * description: 导演类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 22:02 <br>
 */
public class Director {

    public void direct() {
        // 指定角色的饰演者
        GeLi geLi = new LiuDeHua();

        // 注入具体饰演者到剧本中(构造函数注入方式)
        /*MoAttck moAttck = new MoAttck(geLi);
        moAttck.cityGateAsk();*/

        // 属性注入，其和构造函数注入不同，在实例化剧本时，并未指定任何饰演者，而是在实例化后，在需要隔离出场时才注入饰演者
        /*MoAttck moAttck = new MoAttck();
        moAttck.setGeLi(geLi);
        moAttck.cityGateAsk();*/

        //接口方法注入，其需要额外声明一个接口，增加了类的数目，而且它的效果和属性注入并无区别，因此不提倡这种注入方式
        MoAttck moAttck = new MoAttck();
        moAttck.injectGeli(geLi);
        moAttck.cityGateAsk();

    }
}
