/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.autowiredannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AutowiringAmbiguityDemo {

    @Autowired
    DesktopComputer desktopComputer;

    @Autowired
    LaptopComputer laptopComputer;

    public static void main(String[] args) {
        SpringApplication.run(AutowiringAmbiguityDemo.class);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            System.out.println(desktopComputer);
        };
    }

    @Bean
    public CommandLineRunner run2() throws Exception {
        return args -> {
            System.out.println(laptopComputer);
        };
    }
}
