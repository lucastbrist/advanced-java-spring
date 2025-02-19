package com.codingnomads.corespring.examples.application_context.frameworkevents;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

// @Component tells Spring that this is a bean it should register
@Component
public class ContextRefreshedListener2 implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Application is ready!");
    }
}
