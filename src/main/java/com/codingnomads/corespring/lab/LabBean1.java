package com.codingnomads.corespring.lab;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class LabBean1 implements InitializingBean, DisposableBean {

    public LabBean1() {
        System.out.println("I'm the first lab bean! I'm a prototype!");
    }

    @Override
    @Profile("test")
    public void destroy() throws Exception {
        System.out.println("What a world!");
    }

    @Override
    @Profile("test")
    public void afterPropertiesSet() throws Exception {
        System.out.println("I'm melting!");
    }
}
