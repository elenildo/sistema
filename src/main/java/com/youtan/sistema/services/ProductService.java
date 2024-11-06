package com.youtan.sistema.services;

import com.youtan.sistema.dto.ProductDto;
import com.youtan.sistema.dto.ProductDtoIn;
import com.youtan.sistema.models.Product;
import com.youtan.sistema.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(ProductDtoIn productDto) {
        return productRepository.save(new Product(productDto));
    }

    public List<ProductDto> listAll() {
        return productRepository.findAll().stream().map(ProductDto::new).toList();
    }
}
