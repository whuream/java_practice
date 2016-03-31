package me.sutong.java.embed;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by tong on 3/31/16.
 */
public class JsTest {

    @Test
    public void test() throws ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");

        scriptEngine.eval("print('Hello, World')");

        scriptEngine.eval("var obj = new Object(); obj.hello = 'hello'");

        Object object = scriptEngine.get("obj");

        System.out.println(JSON.toJSONString(object));

        scriptEngine.put("a", 12l);

        scriptEngine.eval("a *= a");

        Double a = (Double)scriptEngine.get("a");

        System.out.println(a);
    }
}
