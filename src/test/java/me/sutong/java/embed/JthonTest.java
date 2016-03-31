package me.sutong.java.embed;

import org.junit.Test;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.Arrays;

/**
 * Created by tong on 3/31/16.
 */
public class JthonTest {

    @Test
    public void test(){
        PythonInterpreter pythonInterpreter = new PythonInterpreter();

        pythonInterpreter.set("number", 12l);

        pythonInterpreter.exec("number *= number");

        PyObject number = pythonInterpreter.get("number");

        Object numberLong = number.__tojava__(Long.class);

        System.out.println(Arrays.asList(number.toString(), numberLong.getClass().toString(),
                numberLong.toString()));
    }
}
