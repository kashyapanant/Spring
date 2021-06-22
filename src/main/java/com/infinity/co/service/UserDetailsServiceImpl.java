package com.infinity.co.service;

import com.infinity.co.constants.Constants;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.model.UserDetailsRequest;
import com.infinity.co.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public ResponseContext saveUserDetails(UserDetailsRequest detailsRequest) {
        ResponseContext responseContext = new ResponseContext();
        responseContext.setRequestId(detailsRequest.getRequestContext().getRequestId());
        userDetailsRepository.insert(detailsRequest.getUserDetails());
        responseContext.setResponseMessage(Constants.SUCCESS);
        responseContext.setResponseCode(Constants.SUCCESS_CODE);
        return responseContext;
    }
}
