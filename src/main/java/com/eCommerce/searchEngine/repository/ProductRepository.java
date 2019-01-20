package com.eCommerce.searchEngine.repository;

import com.eCommerce.searchEngine.document.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends SolrCrudRepository<Product, String> {
    @Query("productName:*?0* OR productUsp:*?0* OR productDescription:*?0*")
    public Page<Product> queryDbLimit(String query, Pageable pageable);

    @Query("productName:*?0* OR productUsp:*?0* OR productDescription:*?0*")
    public Iterable<Product> queryDbNoLimit(String query);
}
