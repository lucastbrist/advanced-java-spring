/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    @Before("execution(* com.codingnomads.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    public void beforeGreeting() {
        System.out.println("Before");
    }

    @AfterReturning("execution(* com.codingnomads.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    public void afterReturningGreeting() {
        System.out.println("After Returning");
    }

    @Pointcut("execution(* com.codingnomads.aspectorientedprogramming.lab.service.GreetingService.farewell(..))")
    public void farewellMethod() {}

    @Before("farewellMethod()")
    public void beforeFarewell() {
        System.out.println("Before Farewell");
    }

}
