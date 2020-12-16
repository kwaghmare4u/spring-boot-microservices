package com.alpha.controller;

import com.alpha.entity.User;
import com.alpha.service.UserService;
import com.alpha.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "{id}")
    public ResponseTemplateVO getUserWithDepartmentDetails(@PathVariable(value = "id") Long userId){
        return userService.getUserWithDepartmentDetails(userId);
    }
}
