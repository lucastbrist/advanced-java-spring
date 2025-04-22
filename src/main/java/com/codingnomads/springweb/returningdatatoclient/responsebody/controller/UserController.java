/* CodingNomads (C)2024 */
package com.codingnomads.springweb.returningdatatoclient.responsebody.controller;

import com.codingnomads.springweb.returningdatatoclient.responsebody.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.com")
            .build();

    // using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    // using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // returning a POJO without ResponseBody or using a ResponseEntity - error expected
    @GetMapping("/user")
    public User user() {
        return user;
    }


    // LIST!

    public User newUser1 = User.builder()
            .id(3000)
            .name("Luke Skywalker")
            .email("jedi@holo.net")
            .build();

    public User newUser2 = User.builder()
            .id(3001)
            .name("Leia Organa")
            .email("royalpain@holo.net")
            .build();

    public User newUser3 = User.builder()
            .id(3002)
            .name("Han Solo")
            .email("flyboy@holo.net")
            .build();

    List<User> userList = Arrays.asList(newUser1, newUser2, newUser3);

    @ResponseBody
    @GetMapping("/user-list")
    public List listResponseBody() {
        return userList;
    }
}
