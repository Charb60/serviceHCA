package com.example.websev.controller;

import com.example.websev.model.Product;

import com.example.websev.repository.AddProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AddProductController {

    @Autowired
    AddProductRepository addProductRepository;

    @PostMapping(value = "addproduct")
    public ResponseEntity<String> addProductController(@RequestBody Product addproduct) {

        int result = addProductRepository.addNewProduct(addproduct);

        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("Add new product successfully");

        } else {
            return ResponseEntity
                    .ok()
                    .body("Add new product failed");
        }
    }

}
