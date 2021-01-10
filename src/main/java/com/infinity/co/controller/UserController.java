package com.infinity.co.controller;

import com.infinity.co.constants.Constants;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.model.UserRequest;
import com.infinity.co.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseContext> signup(@RequestBody UserRequest userRequest){
        ResponseContext responseContext = new ResponseContext();
        try {
            responseContext = userService.saveUsers(userRequest);
        }catch (Exception e){
            responseContext.setResponseMessage(Constants.FAILURE);
            responseContext.setResponseCode(Constants.FAILURE_CODE);
            return new ResponseEntity<>(responseContext, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseContext, HttpStatus.OK);




    }
}
