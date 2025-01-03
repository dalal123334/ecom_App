package org.sid.bellingservice.service;

import jakarta.persistence.ForeignKey;
import org.sid.bellingservice.module.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.config.SpringDataJacksonConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path ="/products/{id}" )
    public Product findProductById(@PathVariable Long id);
    @GetMapping(path = "/products")
   PagedModel<Product> allProduct();
}
