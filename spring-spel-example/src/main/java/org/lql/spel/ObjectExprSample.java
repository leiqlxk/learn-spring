package org.lql.spel;

import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * Title: ObjectExprSample <br>
 * ProjectName: learn-spring <br>
 * description: 赋值、类型、构造器、变量、集合过滤、集合转换 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 17:01 <br>
 */
public class ObjectExprSample {

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 赋值
        parser.parseExpression("userName").setValue(context, "jony");
        System.out.println(user.getUserName());

        parser.parseExpression("userName = 'tom'").getValue(context);
        System.out.println(user.getUserName());

        // 类型
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(stringClass == String.class);

        Class userClass = parser.parseExpression("T(org.lql.User)").getValue(Class.class);
        System.out.println(userClass == User.class);

        // 构造器
        User user1 = parser.parseExpression("new org.lql.User('tom')").getValue(User.class);
        System.out.println(user1.getUserName());

        // 变量
        context.setVariable("newUserName", "jony");
        parser.parseExpression("userName=#newUserName").getValue(context);
        System.out.println(user.getUserName());

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(150, 200, 100, 90));
        context.setVariable("list", list);
        List<Integer> greater100 = (List<Integer>) parser.parseExpression("#list.?[#this>100]").getValue(context);
        System.out.println(greater100);

        // 集合过滤 .?[selectExpression]-返回所有结果  .^[selectExpression]-第一个结果  .$[selectExpression]-最后一个结果
        Map<String,Integer> creditsMap = new HashMap();
        creditsMap.put("aTom",95);
        creditsMap.put("bJony",110);
        creditsMap.put("cMorin",85);
        creditsMap.put("dMose",120);
        creditsMap.put("eMorrow",60);
        creditsMap.put("eMorr2ow",90);
        context.setVariable("credits",creditsMap);

        Map<String, Integer>  creditsGreater100 = (Map<String, Integer>) parser.parseExpression("#credits.?[value>90]").getValue(context);
        System.out.println(creditsGreater100);

        // 集合转换 得到一个是否大于90的boolean值集合
        List creditsGreater100Map= (List)parser.parseExpression("#credits.![value>90]").getValue(context);
        System.out.println(creditsGreater100Map);
    }



}
