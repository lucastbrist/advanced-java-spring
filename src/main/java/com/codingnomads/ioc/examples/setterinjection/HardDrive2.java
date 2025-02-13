package com.codingnomads.ioc.examples.setterinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@AllArgsConstructor
@ToString

public class HardDrive2 {
    private String name;
    private String brand;

}
