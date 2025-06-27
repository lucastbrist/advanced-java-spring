/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.addingauthorization.controllers;

import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserMeta;
import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserPrincipal;
import com.codingnomads.springsecurity.authorization.addingauthorization.repositories.UserMetaRepo;
import com.codingnomads.springsecurity.authorization.addingauthorization.repositories.UserPrincipalRepo;
import com.codingnomads.springsecurity.authorization.addingauthorization.services.CustomUserService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    CustomUserService userDetailsService;

    @Autowired
    UserMetaRepo userMetaRepo;

    @Autowired
    UserPrincipalRepo userPrincipalRepo;

    @PostMapping("/update-user")
    public UserMeta updateUser(@RequestBody UserMeta userToUpdate) {
        return userDetailsService.updateUserMeta(userToUpdate);
    }

    @GetMapping("/current-user")
    public UserMeta getUser(Authentication authentication) {
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        return principal.getUserMeta();
    }

    @PostMapping("/create-user")
    public Optional<UserMeta> createUser(@RequestBody UserPrincipal userToCreate) throws NotFoundException {
        return userDetailsService.createUser(userToCreate);
    }

    @GetMapping("/get-id")
    public Long getId(@RequestBody String username) throws NoSuchElementException {
        return userPrincipalRepo.findByUsername(username).get().getId();
    }

    @GetMapping("/get-username")
    public String getUsername(@RequestBody Long id) throws NoSuchElementException {
        return userPrincipalRepo.findById(id).get().getUsername();
    }

    @GetMapping("/get-email")
    public String getEmail(@RequestBody Long id) throws NoSuchElementException {
        return userPrincipalRepo.findById(id).get().getUserMeta().getEmail();
    }

    /*
       Method Security Annotations

       @RolesAllowed("ROLE_USER")
       @PreAuthorize("#id != 1")
       @PostAuthorize("returnObject.ownerUsername == authentication.principal.username")
       @PreFilter(value = "filterObject != shutdown", filterTarget = "commands")
       @PostFilter("filterObject.id <= 20")
    */
}
