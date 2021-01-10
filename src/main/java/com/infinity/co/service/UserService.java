package com.infinity.co.service;

import com.infinity.co.model.ResponseContext;
import com.infinity.co.model.UserRequest;

public interface UserService {

    ResponseContext saveUsers(UserRequest request);
}
