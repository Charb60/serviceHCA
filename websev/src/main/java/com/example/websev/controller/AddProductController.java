package com.example.websev.controller;

import com.example.websev.model.ImageProduct;
import com.example.websev.model.Product;
import com.example.websev.repository.AddProductRepository;
import com.example.websev.repository.ProductRepository;
import com.example.websev.repository.ImageProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AddProductController {

    @Autowired
    private AddProductRepository addProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageProductRepository imageProductRepository;

    @PostMapping(value = "addproduct")
    public ResponseEntity<String> addProductController(@RequestBody Product addproduct) {
        int result = addProductRepository.addNewProduct(addproduct);

        if (result != 0) {
            return ResponseEntity.ok().body("Add new product successfully");
        } else {
            return ResponseEntity.ok().body("Add new product failed");
        }
    }

    @PostMapping(value = "product-and-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addProductImageController(
            @RequestParam("image") List<MultipartFile> images,
            @RequestParam("productData") String productData) {

        ObjectMapper objectMapper = new ObjectMapper();
        Product product;
        try {
            product = objectMapper.readValue(productData, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to parse product data.");
        }

        // เพิ่ม Product ลงในbase
        int result = addProductRepository.addNewProduct(product);

        Long productId = product.getProductId();
        if (result != 0) {
            try {
                // ค้นหา Product ที่เพิ่มลงในbase
                List<Product> productList = productRepository.findByProductId(productId);
                if (productList.isEmpty()) {
                    return ResponseEntity.badRequest().body("Product with ID " + productId + " not found.");
                }
                Product foundProduct = productList.get(0);

                // อัปโหลดรูปภาพสำหรับ Product ที่เพิ่มลงในbase
                for (MultipartFile image : images) {
                    byte[] imageBytes = image.getBytes();
                    ImageProduct imageProduct = new ImageProduct();
                    imageProduct.setImage(imageBytes);
                    imageProduct.setProduct(foundProduct);
                    int rowsAffected = addProductRepository.addImages(imageProduct);
                    if (rowsAffected <= 0) {
                        return ResponseEntity.badRequest().body("Failed to add images for product ID: " + productId);
                    }
                }
                return ResponseEntity.ok("Images uploaded successfully for product (ID: " + productId + ").");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("Failed to upload images.");
            }
        } else {
            return ResponseEntity.badRequest().body("Failed to add product.");
        }
    }


    @GetMapping(value = "products")
    public ResponseEntity<ArrayList<Product>> queryAllProductAndImage() {
        return ResponseEntity
                .ok()
                .body(addProductRepository.queryAllProduct());
    }


@GetMapping(value = "images")
public ResponseEntity<List<ImageProduct>> queryAllImage() {
    return ResponseEntity
            .ok()
            .body(addProductRepository.queryAllImage());
}

    @GetMapping(value = "products-and-images/{productId}")
    public ResponseEntity<List<Product>> queryProductAndImages(@PathVariable Long productId) {
        List<Product> productList = productRepository.findByProductId(productId);
        if (productList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ImageProduct> imageProducts = imageProductRepository.findByProductId(productId);
//        List<ImageProduct> imageProducts = addProductRepository.queryAllImage();

        productList.get(0).setImages(imageProducts);

        return ResponseEntity.ok().body(productList);
    }
}
