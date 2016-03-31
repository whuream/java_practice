package me.sutong.java.embed;

import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.lang.Binding;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by tong on 3/31/16.
 */
public class GroovyTest {

    @Test
    public void test() throws IOException, ResourceException, ScriptException {
        Binding binding = new Binding();

        binding.setVariable("number", 12l);

        GroovyShell groovyShell = new GroovyShell(binding);

        Object retNull = groovyShell.evaluate("println 'hello world!'");

        Object ret = groovyShell.evaluate("number *= number");

        Object numberLong = binding.getVariable("number");

        System.out.println(Arrays.asList(numberLong.getClass().toString(), numberLong.toString(),
                ret.getClass().toString(), ret.toString(), retNull));

    }
}
