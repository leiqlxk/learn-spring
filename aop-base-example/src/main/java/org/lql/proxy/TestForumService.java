package org.lql.proxy;

import java.lang.reflect.Proxy;

/**
 * Title: TestForumService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 9:54 <br>
 */
public class TestForumService {

    public static void main(String[] args) {
        // 目标对象
        ForumService forumService = new ForumServiceImpl();
        /*forumService.removeTopic(20);
        forumService.removeForum(20);*/

        // jdk动态代理
        // 将目标对象和横切面代码编织到一起
        PerformanceHandler ph = new PerformanceHandler(forumService);

        // 根据编织了目标业务类逻辑和性能监控横切逻辑的Invocation实例创建代理实例，其创建的是符合接口的实例，所以代理的目标类必须有实现某个接口
        ForumService proxy = (ForumService) Proxy.newProxyInstance(forumService.getClass().getClassLoader(), forumService.getClass().getInterfaces(), ph);

        proxy.removeTopic(10);
        proxy.removeForum(1024);


        // cglib
        CglibProxy proxy1 = new CglibProxy();
        // 通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService1 = (ForumServiceImpl) proxy1.getProxy(ForumServiceImpl.class);
        forumService1.removeForum(10);
        forumService1.removeTopic(1023);
    }
}
