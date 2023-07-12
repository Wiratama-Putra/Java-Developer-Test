package com.spring.springtemplate.controller;


import com.spring.springtemplate.dto.response.LoginResponse;
import com.spring.springtemplate.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public interface UserController {

    @PostMapping("/login")
    ResponseEntity<ResponseDto<LoginResponse>> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    );

    @GetMapping("/job/list")
    public ResponseEntity<ResponseDto<Object>> getJobList(
            @RequestHeader("Authorization") String authorizationHeader
    );
    @GetMapping("/job/detail/{id}")
    public ResponseEntity<ResponseDto<Object>> getJobDetail(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("id") String id
    );
}
