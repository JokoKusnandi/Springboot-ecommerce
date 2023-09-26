package com.joko.service;

import java.util.List;

import com.joko.dao.ProductCategory;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    ProductCategory getProductCategoryById(Long productCategoryId);

    ProductCategory createProductCategory(ProductCategory productCategory);

    ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategory);

    void deleteProductCategory(Long productCategoryId);
}
