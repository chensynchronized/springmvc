package com.chm;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.add(1, 3);
        System.out.println(result);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        int result = calculator.mul(3, 6);
//        System.out.println(result);
    }
//测试后置通知的位置
//在finally子句中执行
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        int result = calculator.div(6, 0);
        System.out.println(result);
    }

    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        int result = calculator.div(6, 2);
        System.out.println(result);
    }
}
