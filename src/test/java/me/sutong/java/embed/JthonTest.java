package me.sutong.java.embed;

import org.junit.Test;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * Created by tong on 3/31/16.
 */
public class JthonTest {

    @Test
    public void test(){
        PythonInterpreter pythonInterpreter = new PythonInterpreter();

        pythonInterpreter.set("a", 12l);

        pythonInterpreter.exec("a *= a");

        PyObject a = pythonInterpreter.get("a");

        Long l = (Long)a.__tojava__(Long.class);

        System.out.println(l);
    }
}
