package com.codingnomads.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Framework.class)
public class ImportLabConfig {

    @Bean
    Framework newFramework() { return new Framework(); }
}
