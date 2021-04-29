package org.lql.ioc;

/**
 * Title: MoAttck <br>
 * ProjectName: ioc-base-example <br>
 * description: 剧本实例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/29 21:43 <br>
 */
public class MoAttck implements ActorArrangable{

    private GeLi geLi;

    // IOC主要划分为3种类型：构造函数注入、属性注入和接口注入。Spring支持构造函数注入和属性注入
    // 此处为构造函数注入
    /*public MoAttck(GeLi geLi) {
        this.geLi = geLi;
    }*/

    // 属性注入
   /* public void setGeLi(GeLi geLi) {
        this.geLi = geLi;
    }*/

    public void cityGateAsk() {
        // 1.演员直接侵入剧本，使剧本和演员直接耦合在一起
       /* LiuDeHua ldh = new LiuDeHua();
        ldh.responseAsk("墨者革离！");*/

        // 2.引入革离角色，通过接口展开剧情，演员随时可以替换
        // 此时同时依赖于GeLi接口和LiuDeHua类，并没有达到剧本仅依赖于角色的目的
        /*GeLi geLi = new LiuDeHua();
        geLi.responseAsk("墨者革离！");*/

        // 3.通过引入导演，是的剧本和具体饰演者解耦，应当在开拍时导演将LiuDeHua安排在GeLi的角色上
        // 控制反转（IOC）：控制指选择GeLi角色扮演者的控制权；反转是指这种控制权权从剧本中移除，，转交到导演的手中
        // 在软件中即某一接口具体实现类的选择控制权从调用类中移除，转交由第三方决定，即由Spring容器借由Bean配置来进行控制
        this.geLi.responseAsk("墨者革离！");
    }

    // 接口注入
    @Override
    public void injectGeli(GeLi geLi) {
        this.geLi = geLi;
    }
}
