package com.codingnomads.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    @Pointcut("@annotation(com.codingnomads.aspectorientedprogramming.lab.annotations.Printable)")
    public void printablePointcut() {
    }

    @After("printablePointcut()")
    public void afterPrintable() {
        System.out.println("I've been prunt!!");
    }

}
