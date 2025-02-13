/* CodingNomads (C)2024 */
package com.codingnomads.ioc.examples.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private Processor processor;
    private OS os;
    private HardDrive2 hardDrive2;

    @Autowired
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Autowired
    public void setOs(OS os) {
        this.os = os;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() + "\nOS: " + os.getName();
    }

    @Autowired
    public void setHardDrive2(HardDrive2 hardDrive2) {
        this.hardDrive2 = hardDrive2;
    }
}
