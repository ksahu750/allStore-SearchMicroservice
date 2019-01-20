package com.eCommerce.searchEngine.dto;

import com.eCommerce.searchEngine.document.StaticAttribute;

import java.util.Collection;
import java.util.List;

public class ProductDTO {
    private String productId;

    private String productName;

    private String categoryId;

    private String productUsp;

    private String productImageUrl;

    private String productDescription;

    private Collection<StaticAttribute> staticAttributeList;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Collection<StaticAttribute> getStaticAttributeList() {
        return staticAttributeList;
    }

    public void setStaticAttributeList(Collection<StaticAttribute> staticAttributeList) {
        this.staticAttributeList = staticAttributeList;
    }

    public String getProductId() {

        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductUsp() {
        return productUsp;
    }

    public void setProductUsp(String productUsp) {
        this.productUsp = productUsp;
    }
}
