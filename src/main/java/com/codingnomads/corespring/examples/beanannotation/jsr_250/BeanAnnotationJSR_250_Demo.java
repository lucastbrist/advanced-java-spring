/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanannotation.jsr_250;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAnnotationJSR_250_Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanAnnotation_JSR_250_Config.class);
        ctx.refresh();
        SampleBean sampleBean = ctx.getBean(SampleBean.class);
        ctx.close();
    }
}
