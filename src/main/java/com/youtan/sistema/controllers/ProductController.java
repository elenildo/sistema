package com.youtan.sistema.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @GetMapping
    @PreAuthorize("hasHole('PRODUCT_SELECT')")
    public ResponseEntity<?> list() {

        return ResponseEntity.ok().build();
    }
}
