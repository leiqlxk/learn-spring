package org.lql;

import java.math.BigDecimal;
import java.sql.SQLOutput;

/**
 * Title: Test <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 16:34 <br>
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(1.2 - 1);
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal(1)));
    }
}
