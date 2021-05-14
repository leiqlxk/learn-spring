package org.lql.spel;

import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Title: SpelHello <br>
 * ProjectName: learn-spring <br>
 * description: 脱离spring容器单独使用 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 11:46 <br>
 */
public class SpelHello {

    public static void main(String[] args) {
        // 创建SpEL表达式解析器
        ExpressionParser parser = new SpelExpressionParser();
        // 对表达式进行解析
        Expression exp = parser.parseExpression("'Hello' + ' World'");
        String message = (String) exp.getValue();
        System.out.println(message);

        Expression expression = parser.parseExpression("'Hello World'.concat('!')");
        String message1 = (String) expression.getValue();
        System.out.println(message1);

        // 对特定对象属性求值
        User user = new User();
        user.setUserName("Curry");
        user.setCredits(100);

        // 指定一个根对象作为求值目标对象
        EvaluationContext context = new StandardEvaluationContext(user);
        String userName = (String) parser.parseExpression("userName").getValue(context);
        System.out.println(userName);
    }
}
