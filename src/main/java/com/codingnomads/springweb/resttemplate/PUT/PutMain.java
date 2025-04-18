/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PUT;

import com.codingnomads.springweb.resttemplate.PUT.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PUT.models.Task;
import com.codingnomads.springweb.resttemplate.PUT.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            int taskId = 11547;

            ResponseObject responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + taskId, ResponseObject.class);

            Task taskToUpdate;
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The user with ID " + taskId + " could not be found");
            } else {
                taskToUpdate = responseObject.getData();
            }

            User userToUpdate = User.builder().build();
            userToUpdate.setEmail("newemail@newemail.com");
            userToUpdate.setFirst_name("New First Name");
            userToUpdate.setLast_name("New Last Name");
            userToUpdate.setId(taskId);

            // use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(), userToUpdate);
            // get the task to verify update
            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + taskId, ResponseObject.class);
            System.out.println(responseObject.toString());

            userToUpdate.setEmail("now updated with exchange");
            userToUpdate.setFirst_name("Exchange");
            userToUpdate.setLast_name("Student");

            // create an HttpEntity wrapping the task to update
            HttpEntity<User> httpEntity = new HttpEntity<>(userToUpdate);

            // use exchange() to PUT the HttpEntity
            // and map the response to a ResponseEntity
            ResponseEntity<ResponseObject> response =
                    restTemplate.exchange(
                            "http://demo.codingnomads.co:8080/tasks_api/users/" +
                                    userToUpdate.getId(),
                            HttpMethod.PUT,
                            httpEntity,
                            ResponseObject.class
                    );
            System.out.println(response);

        };

    }
}
