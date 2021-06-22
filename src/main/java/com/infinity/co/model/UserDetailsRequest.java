package com.infinity.co.model;

import com.infinity.co.entity.UserDetails;

import java.io.Serializable;

public class UserDetailsRequest implements Serializable {


    private static final long serialVersionUID = 7548742475739711473L;

    private RequestContext requestContext;
    private UserDetails userDetails;


    public RequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "UserDetailsRequest{" +
                "requestContext=" + requestContext +
                ", userDetails=" + userDetails +
                '}';
    }
}
