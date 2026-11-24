package com.orderhub.services;

import com.orderhub.builder.ProductBuilder;
import com.orderhub.dto.product.ProductRequestDto;
import com.orderhub.dto.product.ProductResponseDto;
import com.orderhub.model.Product;
import com.orderhub.execption.ProductNotFoundException;
import com.orderhub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

// 1.Add Product
    public ProductResponseDto addProduct(ProductRequestDto requestDto){
        Product product = ProductBuilder.buildProductFromProductRequestDTO(requestDto);
        Product saved = repository.save(product);
        System.out.println(saved);
       return ProductBuilder.buildProductResponseDTOFromProduct(saved);
    }
// 2. ProductID
    public ProductResponseDto getProductById(Long productId) {

        Product product = repository.findById(productId)
                                    .orElseThrow(() -> new ProductNotFoundException(
                                            "Product not found with ID: " + productId));

        return ProductBuilder.buildProductResponseDTOFromProduct(product);
    }

//    3.List
public List<ProductResponseDto> getAllProducts() {

    List<Product> products = repository.findAll();
    List<ProductResponseDto> responseList = new ArrayList<>();

    for (Product product : products) {
        ProductResponseDto response = ProductBuilder.buildProductResponseDTOFromProduct(product);
        responseList.add(response);
    }
    return responseList;
}

    // 4. Update Product
    public ProductResponseDto updateProduct(
            Long productId, ProductRequestDto requestDto) {

        Product product = repository.findById(productId)
                                     .orElseThrow(() -> new ProductNotFoundException(
                                             "Product not found with ID: " + productId));

        product.setProductname(requestDto.getProductname());
        product.setPrice(requestDto.getPrice());
        product.setQuantity(requestDto.getQuantity());

        Product updated = repository.save(product);

        return ProductBuilder.buildProductResponseDTOFromProduct(updated);
    }

    // 5. Delete Product
    public String deleteProduct(Long productId) {

        Product product = repository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product not found with ID: " + productId));

        repository.delete(product);

        return "Product deleted successfully with ID: " + productId;
    }
}
