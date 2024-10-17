package com.youtan.sistema.models;


import com.youtan.sistema.dto.ProductDtoIn;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal price;

    public Product(ProductDtoIn productDto) {
        this.name = productDto.name();
        this.description = productDto.description();
        this.price = productDto.price();
    }
}
