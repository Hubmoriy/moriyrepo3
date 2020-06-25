package com.alankay.Utils;

import jdk.nashorn.internal.objects.annotations.Property;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * description(描述):
 * author（作者）：河流
 * time：2020/6/24/12:15
 */
@Component("logger")
//此注解表示当前类为切面类
@Aspect
public class Logger {
    //指定切入点表达式
    @Pointcut("execution( * com.alankay.Serviceimpl.*.*(..))")
    private void  Pt1(){

    }
    @Before(" Pt1()")
    //前置通知
    public void beforePrintLog(){
        System.out.println(" 前置通知:beforeprinltLog已开始记实录日志（Logger类）");
    }
   @AfterReturning(" Pt1()")
    //后置通知
    public void afterReturningLog(){
        System.out.println("后置通知:aftereprinltLog已开始记实录日志（Logger类）");
    }
    @AfterThrowing(" Pt1()")
    //异常通知
    public void afterThrowingPrinltLog(){
        System.out.println("异常通知afterThrowingprinltLog已开始记实录日志（Logger类）");
    }
    @After(" Pt1()")
    //最终通知
    public void afterPrinltLog(){
        System.out.println("最终通知finallyprinltLog已开始记实录日志（Logger类）");
    }
    @Around(" Pt1()")
    //环绕通知 手动编码方式！
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
       //明确调用业务层方法（切入点）
        Object returnValue  =  null;
        try{
            //特殊异常特殊拦截
                //获取方法执行所需参数

            Object[] objects = proceedingJoinPoint.getArgs();
                    //在此位置为前置通知
            returnValue =  proceedingJoinPoint.proceed(objects);
                     // 在此位置为后置通知
            return  returnValue;

        }catch(Throwable throwable){
                    //在此位置为异常通知
            throw  new  RuntimeException(throwable);
        }finally {
                     //在此位置为最终通知
            System.out.println("环绕通知aroundPrintLog已开始记实录日志（Logger类）");
        }
       // return  returnValue; 环绕通知运行结果由此代码块所决定
        //System.out.println("环绕通知aroundPrintLog已开始记实录日志（Logger类）");
    }


}
