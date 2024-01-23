package com.chm;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
        int result = calculatorStaticProxy.add(1, 3);
        System.out.println(result);
    }
    @Test
    public void test2(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        int result = proxy.div(4, 2);



    }
}
