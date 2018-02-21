package com.incs.demo.controllers;

import com.incs.demo.entities.Users;
import com.incs.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public String createUsers() {
        return userService.createUsers();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Users> displayUsers(Pageable pageable) {

        return userService.displayUsers(pageable);


    }

    @RequestMapping(value = "/userEmail", method = RequestMethod.GET)
    public Page<Users> displayUsers1(String userEmail, Pageable pageable) {

        return userService.displayUsers1(userEmail, pageable);


    }

    @RequestMapping(value = "/max-offset", method = RequestMethod.GET)
    public Iterable<Users> displayUsers(@RequestParam int max, @RequestParam int offset) {
        return userService.displayUsers(max, offset);
    }


}