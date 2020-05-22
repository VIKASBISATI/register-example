package com.vikas.program.blog.controller;

import com.vikas.program.blog.dto.LoginUser;
import com.vikas.program.blog.dto.RegisterUser;
import com.vikas.program.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody  RegisterUser registerUser){
        authService.signup(registerUser);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/login")
    public void login(@RequestBody LoginUser loginUser){
        authService.login(loginUser);
    }
}
