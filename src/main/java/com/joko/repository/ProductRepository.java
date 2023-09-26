package com.joko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joko.dao.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods if needed
}