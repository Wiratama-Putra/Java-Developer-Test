package com.spring.springtemplate.service.impl;

import com.spring.springtemplate.config.JwtUtils;
import com.spring.springtemplate.dto.response.LoginResponse;
import com.spring.springtemplate.repository.UserRepository;
import com.spring.springtemplate.service.UserService;
import com.spring.springtemplate.service.ValidatorService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public boolean validatetoken(String token) {
        return JwtUtils.validateToken(token.replace("Bearer ", ""));
    }
}
