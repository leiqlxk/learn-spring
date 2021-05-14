package org.lql.spel;

import org.lql.PlaceOfBirth;
import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * Title: PropertyExprSample <br>
 * ProjectName: learn-spring <br>
 * description: 对象属性解析：直接使用xxx.yyy.zzz访问对象属性值 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 14:46 <br>
 */
public class PropertyExprSample {

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国", "厦门"));

        // 构造SpEL解析上下文
        EvaluationContext context = new StandardEvaluationContext(user);

        ExpressionParser expressionParser = new SpelExpressionParser();

        String userName = (String) expressionParser.parseExpression("userName").getValue(context);
        int credits = (int) expressionParser.parseExpression("credits").getValue(context);
        String city = (String) expressionParser.parseExpression("placeOfBirth.city").getValue(context);

        System.out.println(userName);
        System.out.println(credits);
        System.out.println(city);
    }
}
