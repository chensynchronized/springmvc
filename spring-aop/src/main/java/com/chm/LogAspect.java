package com.chm;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
//    重用切入点表达式
    @Pointcut("execution(* com.chm.*.*(..))")
    public void pointCut(){}



//    @Before("execution(public int com.chm.CalculatorImpl.add(int,int))")
//    前置通知
    @Before("execution(* com.chm.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        System.out.println("LogAspect---->前置通知，方法名:"+signature.getName()+"参数为："+ Arrays.toString(joinPoint.getArgs()));
    }
    @After("execution(* com.chm.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        System.out.println("LogAspect--->后置通知，方法名:"+signature.getName()+"参数为："+Arrays.toString(args));
    }
    @AfterReturning(value = "execution(* com.chm.*.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        //获取方法签名信息

        Signature signature = joinPoint.getSignature();
//        获取方法参数
        Object[] args = joinPoint.getArgs();

        System.out.println("LogAspect--->返回通知，方法名"+signature.getName()+"参数为："+Arrays.toString(args)+"返回值为："+result);
    }

    @AfterThrowing(value = "execution(* com.chm.*.*(..))",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception e){

        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LogAspect--->异常通知，方法名"+signature.getName()+"参数为："+Arrays.toString(args)+e);
    }
//    @Around("execution(* com.chm.*.*(..))")
    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("LogAspect--->环绕通知，方法名"+signature.getName()+"参数为："+Arrays.toString(args));
            result = joinPoint.proceed();
            System.out.println("LogAspect--->环绕通知，方法名"+signature.getName()+"参数为："+Arrays.toString(args)+"返回值为："+result);
        } catch (Throwable e) {
            System.out.println("LogAspect--->环绕通知，方法名"+signature.getName()+"参数为："+Arrays.toString(args)+e);

        }finally {
            System.out.println("LogAspect--->环绕通知，方法名"+signature.getName()+"参数为："+Arrays.toString(args)+"返回值为："+result);
        }
        return result;
    }



}
