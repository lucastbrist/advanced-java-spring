/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanscopes.singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SingletonDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        NewBean newBean1 = ctx.getBean(NewBean.class);
        System.out.println("Hash code: " + newBean1.hashCode());

        NewBean newBean2 = ctx.getBean(NewBean.class);
        System.out.println("Hash code: " + newBean2.hashCode());

        ctx.close();
    }
}
