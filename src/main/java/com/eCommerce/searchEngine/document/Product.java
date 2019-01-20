package com.eCommerce.searchEngine.document;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Collection;
import java.util.List;

@SolrDocument(solrCoreName = "product")
public class Product {
    @Id
    @Indexed(name = "id", type = "string")
    private String productId;

    @Field
    @Indexed(name = "productName", type = "string")
    private String productName;

    @Field
    @Indexed(name = "categoryId", type = "string")
    private String categoryId;

    @Field
    @Indexed(name = "productImageUrl", type = "string")
    private String productImageUrl;

    @Field
    @Indexed(name = "productUsp", type = "string")
    private String productUsp;

    @Field
    @Indexed(name = "productDescription", type = "string")
    private String productDescription;

    @Indexed(name = "staticAttributeList", type = "string")
    private Collection<StaticAttribute> staticAttributeList;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public String getProductUsp() {
        return productUsp;
    }

    public void setProductUsp(String productUsp) {
        this.productUsp = productUsp;
    }
}
