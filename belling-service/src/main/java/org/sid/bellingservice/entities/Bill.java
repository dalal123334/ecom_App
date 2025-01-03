package org.sid.bellingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.bellingservice.module.Customer;

import java.util.Date;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date billDate ;
    private Long customerId ;
    @OneToMany (mappedBy = "bill")
   private List<ProductItem> productItems ;
    @Transient
    private Customer customer;
}
