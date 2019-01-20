package com.eCommerce.searchEngine.controller;

import com.eCommerce.searchEngine.document.Product;
import com.eCommerce.searchEngine.document.StaticAttribute;
import com.eCommerce.searchEngine.dto.ProductDTO;
import com.eCommerce.searchEngine.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        Product productCreated  = productService.add(product);
        return new ResponseEntity<String>(productCreated.getProductId(),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findOneProduct", method = RequestMethod.GET)
    public ProductDTO findOneProduct(@RequestParam String productId){
        Product product = productService.findOne(productId);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductDTO> findAllProduct(){
        Iterable<Product> productList = productService.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product _product : productList){
            ProductDTO _productDTO = new ProductDTO();
            BeanUtils.copyProperties(_product, _productDTO);
            productDTOList.add(_productDTO);
        }
        return productDTOList;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteProduct(@RequestParam String productId){
        Product product = productService.findOne(productId);
        productService.delete(productId);
        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        Product productCreated = productService.add(product);
        return new ResponseEntity<String>(productCreated.getProductId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/queryLimit", method = RequestMethod.GET)
    public Page<Product> queryDbLimit(@RequestParam String query, @RequestParam Integer lowerLimit, @RequestParam Integer upperLimit){
        return productService.queryDbLimit(query, lowerLimit, upperLimit);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Iterable<Product> queryDbNoLimit(@RequestParam String query){
        return productService.queryDbNoLimit(query);
    }
}
