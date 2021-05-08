package org.lql.anno;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Title: LoginDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 17:06 <br>
 */
// 标注了Lazy在容器启动时不会立即实例化
@Lazy
@Repository
public class LoginDao {
}
