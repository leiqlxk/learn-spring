package org.lql.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Title: OnePlugin <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 17:23 <br>
 */
// order指定该类的加载顺序，值越小越先加载，如未标注，在将实现类注入到集合类变量中时，实现类顺序是不确定的
@Component
@Order(value = 1)
public class OnePlugin implements Plugin {
}
