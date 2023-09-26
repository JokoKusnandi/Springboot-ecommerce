package com.joko.service;

import java.util.List;

import com.joko.dao.Product;

public interface ProductService {
	
    List<Product> getAllProducts();

    Product getProductById(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product product);

    void deleteProduct(Long productId);

}