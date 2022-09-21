package com.example.hrbackend.controller;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.dto.RegisterForm;
import com.example.hrbackend.service.authUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class authUserController {
    private final authUserService authuserservice ;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm){
        authuserservice.register(registerForm);
        return ResponseEntity.status(201).body(new ApiResponse("New user registered !",201));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Welcome back",200));
    }



}