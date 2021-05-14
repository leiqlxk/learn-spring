package org.lql.spel;

import com.sun.xml.internal.bind.v2.runtime.output.DOMOutput;
import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Title: CompilerSample <br>
 * ProjectName: learn-spring <br>
 * description: 启用SpelCompiler编译器模式示例 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 13:20 <br>
 */
public class CompilerSample {

    public static void main(String[] args) {
        User user = new User();

        // 创建解析器配置，启用编译模式时需要创建一个解析器配置类
        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, CompilerSample.class.getClassLoader());

        // 创建解析器
        SpelExpressionParser parser = new SpelExpressionParser(configuration);

        // 创建取值上下文
        EvaluationContext context = new StandardEvaluationContext(user);

        // 表达式
        String expression = "isVipMember('tom') && isVipMember('jony')";

        // 解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);

        // 通过表达式求值
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
