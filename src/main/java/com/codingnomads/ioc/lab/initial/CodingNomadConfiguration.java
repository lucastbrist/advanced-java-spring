package com.codingnomads.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.codingnomads.ioc.lab.initial")

public class CodingNomadConfiguration {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("3.2").
                build();
    }

    @Bean
    public IDE ide() {
        return IDE.builder().name("IntelliJ IDEA").version("2023.5").
                build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("OpenJDK").version("17").build();
    }
}
