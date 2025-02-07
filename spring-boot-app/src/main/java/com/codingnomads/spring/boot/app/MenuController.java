package com.codingnomads.spring.boot.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/arrival")
    public String sayHello () {
        return "springfundamentals/hello";
    }

    @GetMapping("/departure")
    public String sayGoodbye () {
        return "springfundamentals/goodbye";
    }

}
