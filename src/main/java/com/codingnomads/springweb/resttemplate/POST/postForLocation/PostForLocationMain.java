/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForLocation;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import java.net.URI;
import java.util.Objects;

import com.codingnomads.springweb.resttemplate.POST.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User newUser = User.builder()
                    .email("cooladdress420@gmail.com")
                    .first_name("Coolguy")
                    .last_name("Fawkes")
                    .build();

            // use postForLocation() to get the URL for the new resource
            URI returnedLocation = restTemplate.postForLocation(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/users", newUser, ResponseObject.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate.postForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/users", newUser, ResponseObject.class);

            System.out.println(responseEntity.getHeaders().get("Location"));
        };
    }
}
