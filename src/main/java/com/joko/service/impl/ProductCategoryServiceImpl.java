package com.joko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joko.dao.ProductCategory;
import com.joko.exception.ProductCategoryNotFoundException;
import com.joko.repository.ProductCategoryRepository;
import com.joko.service.ProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryById(Long productCategoryId) {
        return productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new ProductCategoryNotFoundException(productCategoryId));
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategory) {
        if (!productCategoryRepository.existsById(productCategoryId)) {
            throw new ProductCategoryNotFoundException(productCategoryId);
        }
        productCategory.setId(productCategoryId);
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductCategory(Long productCategoryId) {
        if (!productCategoryRepository.existsById(productCategoryId)) {
            throw new ProductCategoryNotFoundException(productCategoryId);
        }
        productCategoryRepository.deleteById(productCategoryId);
    }
}

