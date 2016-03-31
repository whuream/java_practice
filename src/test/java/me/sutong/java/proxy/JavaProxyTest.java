package me.sutong.java.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tong on 3/31/16.
 */
public class JavaProxyTest {

    public interface ProxyTarget{
        Long square(Long input);
    }

    public static class ProxyTargetImpl implements ProxyTarget{
        @Override
        public Long square(Long input) {
            return input * input;
        }
    }

    public static class ProxyTargetProxy implements InvocationHandler{
        private Object target;

        public Object getInstance(Object target){
            this.target = target;

            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("in java proxy");

            Object result = method.invoke(target, args);

            return (Long)result * (Long)result;
        }
    }

    @Test
    public void test(){
        ProxyTargetProxy proxyTargetProxy = new ProxyTargetProxy();

        ProxyTarget proxyTarget = (ProxyTarget) proxyTargetProxy.getInstance(new ProxyTargetImpl());

        System.out.println(proxyTarget.square(2l));
    }
}
