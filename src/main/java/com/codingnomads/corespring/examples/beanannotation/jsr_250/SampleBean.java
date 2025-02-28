/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanannotation.jsr_250;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SampleBean {

    public SampleBean() {
        System.out.println("bean is getting ready!");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean @PostConstruct is gathering resources..");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("time to @PreDestroy and head home..");
    }

    @PostConstruct
    public void postConstructMethod() {
        System.out.println("I have been constructed!");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("I am about to be destroyed!");
    }
}
