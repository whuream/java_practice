package me.sutong.java.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by tong on 3/31/16.
 */
public class CglibTest {

    public static class ProxyTarget{

        public Long square(Long input){
            return input * input;
        }
    }

    public class ProxyTargetCglib implements MethodInterceptor{
        private Object target;

        public Object getInstance(Object target){
            this.target = target;

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(this.target.getClass());
            enhancer.setCallback(this);

            return enhancer.create();
        }


        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("in cglib");

            Object result = methodProxy.invokeSuper(o, objects);

            return (Long)result * (Long)result;
        }
    }

    @Test
    public void test(){
        ProxyTargetCglib proxyTargetCglib = new ProxyTargetCglib();

        ProxyTarget proxyTarget = (ProxyTarget)proxyTargetCglib.getInstance(new ProxyTarget());

        System.out.println(proxyTarget.square(2l));
    }
}
