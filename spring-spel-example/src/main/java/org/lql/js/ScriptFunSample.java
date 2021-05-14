package org.lql.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Title: ScriptFunSample <br>
 * ProjectName: learn-spring <br>
 * description: js脚本函数使用 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 11:25 <br>
 */
public class ScriptFunSample {

    public static void main(String[] args) throws Exception {
        // 创建脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        // 创建脚本引擎，目前jvm支持很多脚本语言如JavaScript、Jruby、Jython等
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String scriptText = "function sum(a, b) { return a + b; }";
        // 注册函数
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("sum", 99, 99);
        System.out.println(result);
    }

}
