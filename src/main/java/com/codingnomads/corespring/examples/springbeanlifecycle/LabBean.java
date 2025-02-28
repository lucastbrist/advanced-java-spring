package com.codingnomads.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class LabBean implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("I was grown in a lab!");
    }
}
