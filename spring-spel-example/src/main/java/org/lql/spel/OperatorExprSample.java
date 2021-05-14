package org.lql.spel;

import org.lql.PlaceOfBirth;
import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * Title: OperatorExprSample <br>
 * ProjectName: learn-spring <br>
 * description: 操作符解析 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 15:39 <br>
 */
public class OperatorExprSample {

    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 关系操作符解析
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);

        trueValue = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);

        falseValue = parser.parseExpression("'xyz' instanceof T(int)").getValue(Boolean.class);

        trueValue = parser.parseExpression("'5.00' matches '^-?\\d(\\.\\d{2})?$'").getValue(Boolean.class);
        falseValue = parser.parseExpression("'5.0067' matches '\\^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);

        // 逻辑操作符
        falseValue = parser.parseExpression("true && false").getValue(Boolean.class);

        trueValue = parser.parseExpression("isVipMember('tom') and isVipMember('jony')").getValue(context, Boolean.class);

        trueValue = parser.parseExpression("true or false").getValue(Boolean.class);

        falseValue = parser.parseExpression("!true").getValue(Boolean.class);

        // 算术运算操作符
        int two = parser.parseExpression("1 + 1").getValue(Integer.class);
        String testString = parser.parseExpression("'test' + ' string'").getValue(String.class);

        int four = parser.parseExpression("1 - -3").getValue(Integer.class);
        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class);

        int six = parser.parseExpression("-2 * -3").getValue(Integer.class);

        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class);
        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class);

        int three = parser.parseExpression("7 % 4").getValue(Integer.class);
        int oneMod = parser.parseExpression("8 / 5 % 2").getValue(Integer.class);

        int minusTwentyOne = parser.parseExpression("1 + 2 - 3 * 8").getValue(Integer.class);

        // 安全导航操作符
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        String city = parser.parseExpression("placeOfBirth?.city").getValue(context, String.class);
        System.out.println(city);
        user.setPlaceOfBirth(null);
        city = parser.parseExpression("placeOfBirth?.city").getValue(context, String.class);
        System.out.println(city);

        // 三元操作符
        int credits = parser.parseExpression("userName == 'tom' ? credits + 10 : credits").getValue(context, Integer.class);
        System.out.println(credits);

    }
}
