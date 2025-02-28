package com.codingnomads.corespring.examples.autowiredannotation;

import org.springframework.stereotype.Component;

@Component
public class QWERTYKeyboard {
    String type() {
        return "I was typed with a QWERTY keyboard!";
    }
}
