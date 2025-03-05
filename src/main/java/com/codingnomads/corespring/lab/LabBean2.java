package com.codingnomads.corespring.lab;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class LabBean2 implements InitializingBean, DisposableBean {

    public LabBean2() {
        System.out.println("I'm the second lab bean! I'm a singleton!");
    }

    @Override
    @Profile("test")
    public void destroy() throws Exception {
        System.out.println("Hello world!");
    }

    @Override
    @Profile("test")
    public void afterPropertiesSet() throws Exception {
        System.out.println("A cruel world!");
    }

}
