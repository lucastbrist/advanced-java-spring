/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForObject;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import com.codingnomads.springweb.resttemplate.POST.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForObjectMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("learn how to use postForObject() - video demo")
//                    .description("get comfortable using the RestTemplate postForObject() method")
//                    // use a valid user id
//                    .userId(380)
//                    .completed(false)
//                    .build();
//
//            ResponseObject taskReturnedByServerAfterPost = restTemplate.postForObject(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);
//
//            if (taskReturnedByServerAfterPost != null) {
//                System.out.println(taskReturnedByServerAfterPost.toString());
//            }

            User newUser = User.builder()
                    .email("emailaddress@emailaddress.com")
                    .first_name("Firstname")
                    .last_name("Lastname")
                    .build();

            ResponseObject responseObject = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users", newUser, ResponseObject.class);

            if (responseObject != null) {
                System.out.println(responseObject.toString());
            }

        };
    }
}
