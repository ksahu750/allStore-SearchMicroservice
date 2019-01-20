package com.eCommerce.searchEngine.service.impl;

import com.eCommerce.searchEngine.document.Product;
import com.eCommerce.searchEngine.repository.ProductRepository;
import com.eCommerce.searchEngine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductRepository productRepository;

    @Override
    @Transactional
    public Product add(Product product) {
        return (Product) productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findOne(String productId) {
        return productRepository.findOne(productId);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(String productId) {
        productRepository.delete(productId);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> queryDbLimit(String query, int lowerLimit, int upperLimit) {
        return productRepository.queryDbLimit(query, new PageRequest(lowerLimit, upperLimit));
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> queryDbNoLimit(String query){
        return productRepository.queryDbNoLimit(query);
    }
}
