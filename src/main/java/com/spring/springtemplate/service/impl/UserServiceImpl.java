package com.spring.springtemplate.service.impl;

import com.spring.springtemplate.config.JwtUtils;
import com.spring.springtemplate.dto.response.LoginResponse;
import com.spring.springtemplate.repository.UserRepository;
import com.spring.springtemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public LoginResponse userLogin(String username, String password) {
        var data = userRepository.findByUsernameAndPassword(username,password);

        LoginResponse response = new LoginResponse();

        if (data.isPresent()){
            response.setId(data.get().getId());
            response.setToken(
                    JwtUtils.generateToken(data.get().getUsername())
            );
        }else {
            response.setId(null);
            response.setToken(null);
        }

        return response;
    }
}
