/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    // autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        // create new user
        User user =
                User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 =
                User.builder().firstName("Joanne").lastName("Joanna").age(36).build();
        User user3 =
                User.builder().firstName("Lucas").lastName("Brist").age(23).build();
        User user4 =
                User.builder().firstName("Big").lastName("Cheese").age(100).build();
        User user5 =
                User.builder().firstName("Luke").lastName("Skywalker").age(23).build();

        // save user and assign what is returned to the user variable.
        user = userRepo.save(user);
        user2 = userRepo.save(user2);
        user3 = userRepo.save(user3);
        user4 = userRepo.save(user4);
        user5 = userRepo.save(user5);

        Iterable<User> users = userRepo.findAll();

        for (User u : users) {
            System.out.println(u.toString());
        }

        // delete the user using the id of the inserted user object
        userRepo.deleteById(user.getId());
        userRepo.deleteById(user2.getId());
        userRepo.deleteById(user3.getId());
        userRepo.deleteById(user4.getId());
        userRepo.deleteById(user5.getId());
    }
}
