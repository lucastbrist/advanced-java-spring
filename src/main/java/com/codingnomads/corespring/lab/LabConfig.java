package com.codingnomads.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:resource.xml"})
public class LabConfig {

    @Bean
    LabBean1 labBean1() { return new LabBean1(); }

    @Bean
    LabBean2 labBean2() { return new LabBean2(); }

}
