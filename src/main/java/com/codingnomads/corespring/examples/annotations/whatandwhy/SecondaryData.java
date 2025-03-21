package com.codingnomads.corespring.examples.annotations.whatandwhy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface SecondaryData {

    String data() default "secondary data return";

}
