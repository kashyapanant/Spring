package com.infinity.co.controller;

import com.infinity.co.model.ResponseContext;
import com.infinity.co.model.UserDetailsRequest;
import com.infinity.co.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/details")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/save")
    public ResponseEntity<ResponseContext> createUserDetails
            (@RequestBody UserDetailsRequest request){
        System.out.println("Recieved Request");
        ResponseContext responseContext = userDetailsService.saveUserDetails(request);
        return new ResponseEntity<>(responseContext, HttpStatus.CREATED);
    }


}
