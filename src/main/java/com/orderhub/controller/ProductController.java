package com.orderhub.controller;

import com.orderhub.dto.product.ProductRequestDto;
import com.orderhub.dto.product.ProductResponseDto;
import com.orderhub.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderHub/Products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto requestDto){
        return new ResponseEntity<>(service.addProduct(requestDto), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long productId) {

        return new ResponseEntity<>(service.getProductById(productId), HttpStatus.OK);
    }

    // 3. Get All Products
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK
        );
    }

    // 4. Update Product
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto requestDto) {

        return new ResponseEntity<>(service.updateProduct(productId, requestDto), HttpStatus.OK);
    }

    // 5. Delete Product
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(service.deleteProduct(productId), HttpStatus.OK);
    }
}
