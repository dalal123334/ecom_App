package org.sid.bellingservice.service;

import org.sid.bellingservice.module.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/customer/{id}")
    public Customer findCustomerById(@PathVariable Long id);
}
