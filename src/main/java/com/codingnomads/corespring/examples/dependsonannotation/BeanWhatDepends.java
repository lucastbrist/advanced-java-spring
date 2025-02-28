package com.codingnomads.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanWhatDepends {

    @Autowired
    private JDK jdk;

    private void beanWhatDepends() {
        System.out.println("I am the bean that depends!");
    }
}
