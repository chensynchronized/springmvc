package com.chm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        /**
         * newProxyInstance()：创建一个代理实例
         * 其中有三个参数：
         * 1、classLoader：加载动态生成的代理类的类加载器
         * 2、interfaces：目标对象实现的所有接口的class对象所组成的数组
         * 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接
         口中的抽象方法
         */

        InvocationHandler h = new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * proxy：代理对象
                 * method：代理对象需要实现的方法，即其中需要重写的方法
                 * args所对应方法的参数
                 */
                System.out.println("[日志]  "+method.getName()+"方法开始了，参数为" + Arrays.toString(args));
                Object invoke = method.invoke(target, args);
                System.out.println("[日志]  "+method.getName()+"方法结束了，结果为" + invoke);
                return invoke;
            }
        };
        Class<?>[] interfaces = target.getClass().getInterfaces();
        ClassLoader classLoader = this.getClass().getClassLoader();
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
