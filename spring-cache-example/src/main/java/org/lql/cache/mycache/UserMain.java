package org.lql.cache.mycache;

/**
 * Title: UserMain <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 11:20 <br>
 */
public class UserMain {

    // 自定义缓存可以正常工作，但这种实现方式并不优雅：缓存代码和业务代码高度耦合，业务代码中穿插着大量的缓存控制逻辑，并且代码显示依赖缓存的具体实现。
    public static void main(String[] args) {
        UserService userService = new UserService();

        // 开始查询账号
        userService.getUserById("00001001");
        userService.getUserById("00001001");

        // 重置缓存
        userService.reload();

        System.out.println("after reload.....");
        userService.getUserById("00001001");
        userService.getUserById("00001001");
    }
}
