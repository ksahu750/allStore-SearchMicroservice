package com.eCommerce.searchEngine.service;

import com.eCommerce.searchEngine.document.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product add(Product product);
    Product findOne(String productId);
    Iterable<Product> findAll();
    void delete(String productId);
    Product update(Product product);
    Page<Product> queryDbLimit(String query, int lowerLimit, int upperLimit);
    Iterable<Product> queryDbNoLimit(String query);
}
