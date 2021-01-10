package com.infinity.co.model;

import com.infinity.co.entity.User;

import java.io.Serializable;
import java.util.List;

public class UserRequest implements Serializable {

    private static final long serialVersionUID = -3193550433132973016L;

    private List<User> userList;

    private RequestContext requestContext;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userList=" + userList +
                ", requestContext=" + requestContext +
                '}';
    }
}
