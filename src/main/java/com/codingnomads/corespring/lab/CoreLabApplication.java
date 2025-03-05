/* CodingNomads (C)2024 */
package com.codingnomads.corespring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreLabApplication {

    public static void main(String[] args) {

        System.out.println("Sound off, beans!");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(LabConfig.class);

        LabBean1 labBean1 = ctx.getBean(LabBean1.class);
        System.out.println(labBean1.hashCode());

        LabBean2 labBean2 = ctx.getBean(LabBean2.class);
        System.out.println(labBean2.hashCode());

        System.out.println("I didn't that second part. Let's hear your hashcodes again!");

        System.out.println(labBean1.hashCode());

        System.out.println(labBean2.hashCode());



    }

}
