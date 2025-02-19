package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String name;

    public Country(String name) {
        this.name = name;
    }
}
