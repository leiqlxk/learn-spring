package org.lql.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Title: ToolTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 14:43 <br>
 */
public class ToolTest {

    @Test
    public void tool() {
        Class clazz = ForumService.class;
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (needTest != null) {
                if(needTest.value()) {
                    System.out.println(method.getName() + "()需要测试");
                }else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
