package com.vikas.program.blog.service;

import com.vikas.program.blog.dto.LoginUser;
import com.vikas.program.blog.dto.RegisterUser;
import com.vikas.program.blog.model.User;
import com.vikas.program.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    public void signup(RegisterUser registerUser){
        User user = new User();
        user.setUserName(registerUser.getUserName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(encodePassword(registerUser.getPassword()));
        userRepository.save(user);
    }
    public void login(LoginUser loginUser){
        Authentication authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(),
                loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }
    private String encodePassword(String pwd){
        return passwordEncoder.encode(pwd);
    }

}
