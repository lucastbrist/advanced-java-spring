/* CodingNomads (C)2024 */
package com.codingnomads.springweb.springrestcontrollers.simpledemo.controller;

import com.codingnomads.springweb.resttemplate.PUT.models.Task;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/goodbye", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String goodbye() {
        return "Goodbye!";
    }

    @RequestMapping(path = "/didyouknow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String didYouKnow() {
        return "Did you know that \"URL\" stands for \"Universal Resource Locator?\"";
    }

    @RequestMapping(path = "/lister", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> lister() {
        List<String> list = new ArrayList<>();
        list.add("Hello!");
        list.add(" This");
        list.add(" is");
        list.add(" a");
        list.add(" list!");
        return list;
    }

    @RequestMapping(path = "/pojo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task pojo() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();

        return task;
    }
}
