package org.springframework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

public class MyTest {
    @Test
    public void func() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before");
            Object result = proxy.invokeSuper(obj, args1);
            System.out.println("after");
            return result;
        });
        SimpleClass simpleClass = (SimpleClass) enhancer.create();
        simpleClass.sayHello();
    }
}
