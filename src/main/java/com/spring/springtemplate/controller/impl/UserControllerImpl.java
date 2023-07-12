package com.spring.springtemplate.controller.impl;


import com.spring.springtemplate.controller.UserController;
import com.spring.springtemplate.dto.response.ResponseDto;
import com.spring.springtemplate.dto.response.LoginResponse;
import com.spring.springtemplate.service.UserService;
import com.spring.springtemplate.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;
    @Autowired
    ValidatorService validatorService;


    @Override
    public ResponseEntity<ResponseDto<LoginResponse>> login(String username, String password) {
        var login = userService.userLogin(username,password);
        ResponseDto<LoginResponse> data = new ResponseDto<>();
        data.setSuccess(true);
        data.setMessage(login.getId() != null ?"success" : "login failed");
        data.setData(login.getId() !=null ? login : null);

        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<ResponseDto<Object>> getJobList(String authorization) {
        ResponseDto<Object> data = new ResponseDto<>();
        data.setSuccess(false);
        data.setMessage("failed");
        data.setData(null);

        if (validatorService.validatetoken(authorization)){
            final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
            RestTemplate restTemplate = new RestTemplate();
            Object result = restTemplate.getForObject(uri, Object.class);
            data.setSuccess(true);
            data.setMessage("success");
            data.setData(result);

            return ResponseEntity.ok(data);
        }
        return ResponseEntity.status(498).body(data);

    }

    @Override
    public ResponseEntity<ResponseDto<Object>> getJobDetail(String authorization, String id) {
        ResponseDto<Object> data = new ResponseDto<>();
        data.setSuccess(false);
        data.setMessage("failed");
        data.setData(null);

        if (validatorService.validatetoken(authorization)){
            final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id;
            RestTemplate restTemplate = new RestTemplate();
            Object result = restTemplate.getForObject(uri, Object.class);
            data.setSuccess(true);
            data.setMessage("success");
            data.setData(result);

            return ResponseEntity.ok(data);
        }
        return ResponseEntity.status(498).body(data);
    }

}
