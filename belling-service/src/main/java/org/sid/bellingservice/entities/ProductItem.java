package org.sid.bellingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bellingservice.module.Product;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long productId ;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY )
    private Bill bill;
    private int quantity;
    private double price ;
    private double discount ;
    @Transient
    private Product product ;


}
