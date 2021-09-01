package com.saichethan.SpringBootProject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class Logging {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    boolean checkLogin = false;

    @Before("com.saichethan.SpringBootProject.aop.AopExpressions.forLogin()")
    public void beforeUserLogin(JoinPoint joinPoint) // joinPoint has the metadata about method call
    {
        myLogger.info("\nExecuting @Before advice on showWelcome()");

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = Integer.parseInt(name);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        if(!checkLogin){
            myLogger.info(" User id = "+ id+ " login at " + now);
            checkLogin = true;
        }
    }


    @AfterReturning("com.saichethan.SpringBootProject.aop.AopExpressions.forLogout()")
    public void afterUserLogout(JoinPoint joinPoint) // joinPoint has the metadata about method call
    {
        myLogger.info("\nExecuting @After advice on afterLogout()");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        myLogger.info(" Logout at " + now);
    }

}
