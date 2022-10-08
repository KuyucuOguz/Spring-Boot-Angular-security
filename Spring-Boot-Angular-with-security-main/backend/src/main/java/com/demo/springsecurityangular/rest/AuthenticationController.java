package com.demo.springsecurityangular.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springsecurityangular.dto.ResponseDTO;
import com.demo.springsecurityangular.dto.UserDTO;
import com.demo.springsecurityangular.session.SessionRegistry;
import com.demo.springsecurityangular.user.UserEntity;
import com.demo.springsecurityangular.user.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
public class AuthenticationController {
    @Autowired
    public AuthenticationManager manager;
    @Autowired
    public SessionRegistry sessionRegistry;
    @Autowired
    public UserRepository userRepo;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO user) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        final String sessionId = sessionRegistry.registerSession(user.getUsername());
        ResponseDTO response = new ResponseDTO();
        response.setSessionId(sessionId);

        
        System.out.println(sessionId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/process_register")
    public void processRegister(@RequestBody UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
    }
}
