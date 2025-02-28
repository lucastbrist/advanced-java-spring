package com.codingnomads.corespring.examples.propertysourceannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Lab {
    @Value("${lab.name}")
    private String labName;

    @Value("${lab.version}")
    private String labVersion;

    public String getLabName() {
        return labName;
    }

    public String getLabVersion() {
        return labVersion;
    }
}
