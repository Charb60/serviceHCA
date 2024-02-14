package com.example.websev.controller;

import com.example.websev.model.User;
import com.example.websev.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "users")
    public ResponseEntity<ArrayList<User>> getAllUserController() {
        return ResponseEntity
                .ok()
                .body(userRepository.queryAllUser());
    }

    @PostMapping(value = "user")
    public ResponseEntity<String> addUserController(@RequestBody User user) {
        int result = userRepository.insertNewUser(user);

        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("add new user successfully");

        } else {
            return ResponseEntity
                    .ok()
                    .body("add new user failed");
        }
    }

    @PutMapping(value = "user")
    public ResponseEntity<String> updateUserById(@RequestBody User user) {
        int result = userRepository.updateUserById(user);
        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("Update successful");
        } else {
            return ResponseEntity
                    .ok()
                    .body("Update failed");

        }

    }

    @DeleteMapping(value = "user/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") Long id) {
        int result = userRepository.deleteUserById(id);
        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("delete successful");
        } else {
            return ResponseEntity
                    .ok()
                    .body("delete failed");
        }

    }

//    @PostMapping(value ="user-and-image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> addUserImageController(@RequestParam (name = "userData") String userData,
//                                                         @RequestParam (name = "image") MultipartFile image) throws IOException {
//
//        ObjectMapper objectMepper = new ObjectMapper();
//        User user = objectMepper.readValue(userData, User.class);
//        byte[] imageUser = image.getBytes();
//        user.setImage(imageUser);
//        try {
//            int result = userRepository.insertNewUser(user);
//            if (result != 0) {
//                return ResponseEntity
//                        .ok()
//                        .body("add new user successfully");
//
//            }else {
//                return ResponseEntity
//                        .ok()
//                        .body("add new user failed");
//            }
//            }catch (Exception ex) {
//            return ResponseEntity
//                    .internalServerError()
//                    .body("Can not add new user cause SQL problem: ");
//
//
//        }
//    }


}
