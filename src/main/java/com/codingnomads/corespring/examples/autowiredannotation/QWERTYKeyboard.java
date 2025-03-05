package com.codingnomads.corespring.examples.autowiredannotation;

import org.springframework.stereotype.Component;

@Component("QWERTYKeyboard")
public class QWERTYKeyboard implements Keyboard {
    public String type() {
        return "I was typed with a QWERTY keyboard!";
    }
}
