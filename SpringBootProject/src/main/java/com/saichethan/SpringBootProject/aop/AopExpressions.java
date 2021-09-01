package com.saichethan.SpringBootProject.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.saichethan.SpringBootProject.controller.HomeController.showWelcome(..))")
    public void forLogin() {}

    @Pointcut("execution(* com.saichethan.SpringBootProject.controller.HomeController.afterLogout())")
    public void forLogout() {}
}

