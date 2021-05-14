package org.lql.spel;

import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Title: MethodExprSample <br>
 * ProjectName: learn-spring <br>
 * description: 方法解析 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 15:05 <br>
 */
public class MethodExprSample {

    public static void main(String[] args) {
        User user = new User();

        ExpressionParser expressionParser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 调用String方法
        String substring = expressionParser.parseExpression("'Spring SpEl'.substring(7)").getValue(String.class);
        Integer index = expressionParser.parseExpression("'Spring SpEL'.indexOf('SpEL')").getValue(Integer.class);

        // 调用实例方法
        boolean isCorret = expressionParser.parseExpression("validatePassword('123456')").getValue(context, Boolean.class);

        // 调用私有方法，将发生报错
        isCorret = expressionParser.parseExpression("validatePassword2('123456')").getValue(context, Boolean.class);

        // 调用静态方法
        isCorret = expressionParser.parseExpression("validatePassword3('123456')").getValue(context, Boolean.class);

        // 调用对象方法，可变参数列表
        expressionParser.parseExpression("addInterests('JS', 'C')").getValue(context, Boolean.class);

    }
}
