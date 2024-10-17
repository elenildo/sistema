package com.youtan.sistema.repositories;

import com.youtan.sistema.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
