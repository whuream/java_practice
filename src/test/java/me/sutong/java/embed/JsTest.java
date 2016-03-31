package me.sutong.java.embed;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

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

        scriptEngine.put("number", 12l);

        scriptEngine.eval("number *= number");

        Object numberLong = scriptEngine.get("number");

        System.out.println(Arrays.asList(numberLong.getClass().toString(), numberLong.toString(),
                object.getClass().toString(), JSON.toJSONString(object)));
    }
}
