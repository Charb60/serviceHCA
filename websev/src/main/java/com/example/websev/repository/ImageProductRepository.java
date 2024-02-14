package com.example.websev.repository;

import com.example.websev.model.ImageProduct;
import com.example.websev.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageProductRepository extends JpaRepository<Product, Long> {
    public List<ImageProduct> findByProductId(Long productId);
}
