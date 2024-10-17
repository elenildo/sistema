package com.youtan.sistema.controllers;

import com.youtan.sistema.dto.ProductDtoIn;
import com.youtan.sistema.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(productService.listAll(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    public ResponseEntity<?> save(@RequestBody ProductDtoIn productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }
}
