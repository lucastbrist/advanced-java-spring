package com.codingnomads.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Chair {
    private long id;
    private String brand;
    private int wheels;

    public Chair(long id, String brand, int wheels) {
        this.id = id;
        this.brand = brand;
        this.wheels = wheels;
    }
}
