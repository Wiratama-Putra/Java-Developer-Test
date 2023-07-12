package com.spring.springtemplate.service;


import com.spring.springtemplate.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface ValidatorService {
    boolean validatetoken(String token);
}
