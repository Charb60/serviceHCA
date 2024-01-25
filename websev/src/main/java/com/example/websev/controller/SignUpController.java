package com.example.websev.controller;

import com.example.websev.model.SignUp;
import com.example.websev.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SignUpController {

    @Autowired
    SignUpRepository signUpRepository;

    @PostMapping(value = "signup")
    public ResponseEntity<String> addSignUpController(@RequestBody SignUp signup) {
        int result = signUpRepository.insertNewSignUp(signup);

        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("add new signup successfully");

        } else {
            return ResponseEntity
                    .ok()
                    .body("add new signup failed");
        }
    }
}
