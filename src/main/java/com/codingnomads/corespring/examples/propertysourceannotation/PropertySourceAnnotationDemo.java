/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.propertysourceannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceAnnotationConfig.class);
        ctx.refresh();
        final Lab lab = ctx.getBean(Lab.class);
        System.out.println("Values from lab.properties: " + "Lab Name: " + lab.getLabName() + ", App Version: "
                + lab.getLabVersion());
        ctx.close();
    }
}
