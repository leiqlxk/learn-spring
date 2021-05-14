package org.lql.spel;

import org.lql.PlaceOfBirth;
import org.lql.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * Title: CollectionExprSample <br>
 * ProjectName: learn-spring <br>
 * description: 数组、集合类型解析 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 14:53 <br>
 */
public class CollectionExprSample {

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));
        user.setInterestsArray(new String[]{"Java","C++"});
        Map interestsMap = new HashMap();
        interestsMap.put("interest1","Java");
        interestsMap.put("interest2","C++");
        user.setInterestsMap(interestsMap);
        List<String> interestsList = new ArrayList();
        interestsList.add("Java");
        interestsList.add("C++");
        user.setInterestsList(interestsList);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 数组表达式解析
        int[] arr1 = (int[]) parser.parseExpression("new int[]{1, 2, 3}").getValue(context);
        int[][] arr2 = (int[][]) parser.parseExpression("new int[2][3]").getValue(context);

        // 目前不支持多维数组初始化，以下语句将报错
        int[][] arr3 = (int[][]) parser.parseExpression("new int[2][3]{1, 2, 3}, {4, 5, 6}").getValue(context);

        // List表达式解析
        List list = (List) parser.parseExpression("{1, 2, 3, 4}").getValue();
        List listOfLists = (List) parser.parseExpression("{{'a', 'b'}, {'c', 'd'}}").getValue(context);

        // 列表字符串解析
        Map userInfo = (Map) parser.parseExpression("{userName:'Tom', credits: 100}").getValue(context);

        // 从数组、List、Map中取值
        String interest1 = (String)parser.parseExpression("interestsArray[0]").getValue(context);
        String interest2 = (String)parser.parseExpression("interestsList[0]").getValue(context);
        String interest3 = (String)parser.parseExpression("interestsMap['interest1']").getValue(context);
    }
}
