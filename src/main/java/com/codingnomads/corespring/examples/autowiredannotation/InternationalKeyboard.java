package com.codingnomads.corespring.examples.autowiredannotation;

import org.springframework.stereotype.Component;

@Component
public class InternationalKeyboard {
    String type() {
        return "I was typed with an International Keyboard!";
    }
}
