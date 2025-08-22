/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.lab.service;

import com.codingnomads.aspectorientedprogramming.lab.annotations.Printable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello Spring Developer!";
    }

    @Printable
    public String farewell() {
        return "Goodbye!";
    }

}
