package com.codingnomads.corespring.examples.autowiredannotation;

import org.springframework.stereotype.Component;

@Component("InternationalKeyboard")
public class InternationalKeyboard implements Keyboard {
    public String type() {
        return "I was typed with an International Keyboard!";
    }
}
