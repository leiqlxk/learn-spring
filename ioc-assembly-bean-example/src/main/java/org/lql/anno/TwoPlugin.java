package org.lql.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Title: TwoPlugin <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/8 17:25 <br>
 */
@Component
@Order(value = 2)
public class TwoPlugin implements Plugin {
}
