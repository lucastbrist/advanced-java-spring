package com.codingnomads.spring.boot.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController2 {

    private final Service2 service2;

    public MenuController2(Service2 service2) {
        this.service2 = service2;
    }

    @GetMapping("/success")
    public String success () {
        return "Success";
    }

}
