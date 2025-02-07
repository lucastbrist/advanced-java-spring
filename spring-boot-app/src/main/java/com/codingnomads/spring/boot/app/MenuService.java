package com.codingnomads.spring.boot.app;

import org.springframework.stereotype.Service;

@Service
public class MenuService {

    public MenuService() {
        this.processMenu(true);
    }

    public String processMenu(boolean arriving) {
        if (arriving) {
            return "springfundamentals/hello";
        } else {
            return "springfundamentals/goodbye";
        }
    }
}
