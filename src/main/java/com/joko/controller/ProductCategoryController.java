package com.joko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.joko.dao.ProductCategory;
import com.joko.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/")
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{productCategoryId}")
    public ProductCategory getProductCategoryById(@PathVariable Long productCategoryId) {
        return productCategoryService.getProductCategoryById(productCategoryId);
    }

    @PostMapping("/")
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }

    @PutMapping("/{productCategoryId}")
    public ProductCategory updateProductCategory(@PathVariable Long productCategoryId, @RequestBody ProductCategory productCategory) {
        return productCategoryService.updateProductCategory(productCategoryId, productCategory);
    }

    @DeleteMapping("/{productCategoryId}")
    public void deleteProductCategory(@PathVariable Long productCategoryId) {
        productCategoryService.deleteProductCategory(productCategoryId);
    }
}

