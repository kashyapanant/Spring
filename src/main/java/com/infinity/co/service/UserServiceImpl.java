package com.infinity.co.service;

import com.infinity.co.constants.Constants;
import com.infinity.co.entity.User;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.model.UserRequest;
import com.infinity.co.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseContext saveUsers(UserRequest request){
        ResponseContext responseContext = new ResponseContext();
        responseContext.setRequestId(request.getRequestContext().getRequestId());
        List<User> userList = request.getUserList();
        for(User user : userList) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        responseContext.setResponseCode(Constants.SUCCESS);
        responseContext.setResponseCode(Constants.SUCCESS_CODE);
        return responseContext;
    }
}
