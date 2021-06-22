package com.infinity.co.service;


import com.infinity.co.model.ResponseContext;
import com.infinity.co.model.UserDetailsRequest;

public interface UserDetailsService {

    ResponseContext saveUserDetails(UserDetailsRequest detailsRequest);
}
