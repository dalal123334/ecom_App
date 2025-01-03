package org.sid.bellingservice;

import org.sid.bellingservice.entities.Bill;
import org.sid.bellingservice.entities.ProductItem;
import org.sid.bellingservice.module.Customer;
import org.sid.bellingservice.module.Product;
import org.sid.bellingservice.repository.BillRepository;
import org.sid.bellingservice.repository.ProductItemRepository;
import org.sid.bellingservice.service.CustomerRestClient;
import org.sid.bellingservice.service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BellingServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BellingServiceApplication.class, args);
	}
@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository
							productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient
){
		return args -> {  Collection<Product> products=productRestClient.allProduct().getContent();
			Long customerId=1L;
			Customer customer=customerRestClient.findCustomerById(customerId);
			if(customer==null) throw new RuntimeException("Customer not found");
			Bill bill=new Bill();
			bill.setBillDate(new Date());
			bill.setCustomerId(customerId);
			Bill savedBill = billRepository.save(bill);
			products.forEach(product -> {
				ProductItem productItem=new ProductItem();
				productItem.setBill(savedBill);
				productItem.setProductId(product.getId());
				productItem.setQuantity(1+new Random().nextInt(10));
				productItem.setPrice(product.getPrice());
				productItem.setDiscount(Math.random());
				productItemRepository.save(productItem);
			});

		};

}
}
