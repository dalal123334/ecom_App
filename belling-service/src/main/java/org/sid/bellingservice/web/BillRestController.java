package org.sid.bellingservice.web;

import org.sid.bellingservice.entities.Bill;
import org.sid.bellingservice.module.Customer;
import org.sid.bellingservice.repository.BillRepository;
import org.sid.bellingservice.repository.ProductItemRepository;
import org.sid.bellingservice.service.CustomerRestClient;
import org.sid.bellingservice.service.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired

    private ProductItemRepository productItemRepository;
    @Autowired

    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }
    @GetMapping(path = "/fullBill/{id}")
    public Bill bill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
        });
        return bill;
    }

}
