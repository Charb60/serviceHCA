package com.example.websev.repository;

import com.example.websev.model.ImageProduct;
import com.example.websev.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query
    public List<Product> findByProductName(String productName);
    public List<Product> findByProductId(Long productId);






}
