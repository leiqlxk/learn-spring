package org.lql.aspectj.basic;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.lql.Seller;
import org.lql.SmartSeller;

/**
 * Title: EnableSellerAspect <br>
 * ProjectName: spring-boot-example <br>
 * description: 引介增强 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:09 <br>
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "org.lql.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;
}
