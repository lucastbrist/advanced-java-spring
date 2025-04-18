/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForEntity;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import java.util.Objects;

import com.codingnomads.springweb.resttemplate.POST.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForEntityMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForEntityMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("learn how to use postForEntity()")
//                    .description("get comfortable using the RestTemplate postForEntity() method")
//                    // be sure to use valid user id
//                    .userId(380)
//                    .completed(false)
//                    .build();
//
//            ResponseEntity<ResponseObject> responseEntity = restTemplate.postForEntity(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);
//
//            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
//                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
//            } else {
//                System.out.println(
//                        Objects.requireNonNull(responseEntity.getBody()).getError());
//            }

//            User newUser = User.builder()
//                    .email("jimbob@gmail.com")
//                    .first_name("Jim")
//                    .last_name("Bob")
//                    .build();
//
//            ResponseEntity<ResponseObject> responseEntity2 =
//                    restTemplate.postForEntity(
//                            "http://demo.codingnomads.co:8080/tasks_api/users",
//                            newUser,
//                            ResponseObject.class
//                    );
//
//            if (responseEntity2.getStatusCode().equals(HttpStatus.CREATED)) {
//                System.out.println(
//                        Objects.requireNonNull(responseEntity2.getBody()));
//            } else {
//                System.out.println(
//                        Objects.requireNonNull(responseEntity2.getBody()).getError());
//            }

            User newUser = User.builder()
                    .email("jimbo@gmail.com")
                    .build();

            ResponseEntity<ResponseObject> responseEntity2 =
                    restTemplate.postForEntity(
                            "http://demo.codingnomads.co:8080/tasks_api/users",
                            newUser,
                            ResponseObject.class
                    );

            if (responseEntity2.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(
                        Objects.requireNonNull(responseEntity2.getBody()));
            } else {
                System.out.println(
                        Objects.requireNonNull(responseEntity2.getBody()).getError());
            }

        };

    }
}
