package org.lql.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Title: LiteralExprSample <br>
 * ProjectName: learn-spring <br>
 * description: 文本字符解析：文本表达式支持字符串、日期、数字（正数、实数及十六进制数）、布尔类型及null，
 * 其中字符串需要使用单引号或反斜杆+双引号包含起来 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 13:45 <br>
 */
public class LiteralExprSample {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        // String
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();

        // double
        double doubleNumber = (double) parser.parseExpression("6.0356565656").getValue();

        // int
        int intValue = (int) parser.parseExpression("5465465").getValue();

        // boolean
        boolean trueValue = (boolean) parser.parseExpression("true").getValue();

        // null
        Object nullValue = parser.parseExpression("null").getValue();

        System.out.println(helloWorld);
        System.out.println(doubleNumber);
        System.out.println(intValue);
        System.out.println(trueValue);
        System.out.println(nullValue);
    }
}
