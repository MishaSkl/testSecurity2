package org.example.springsecurity.controllers;


import org.example.springsecurity.entites.User;
import org.example.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainControllers {

    private final UserService userService;

    @Autowired
    public MainControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "secured part wev service: " + principal.getName() + user.getEmail();
    }

    @GetMapping("/read_profile")
    public String pageForReadProfile() {
        return "read profile page";
    }

    @GetMapping("/only_for_admins")
    public String pageOnlyForAdmins() {
        return "admins page";
    }
}
