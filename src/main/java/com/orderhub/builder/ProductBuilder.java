package com.orderhub.builder;


import com.orderhub.dto.product.ProductRequestDto;
import com.orderhub.dto.product.ProductResponseDto;
import com.orderhub.entity.Product;

public class ProductBuilder {

    public static Product buildProductFromProductRequestDTO(ProductRequestDto requestDto){
        return Product.builder()
                .productname(requestDto.getProductname())
                .quantity(requestDto.getQuantity())
                .price(requestDto.getPrice())
                .build();
    }

    public static ProductResponseDto buildProductResponseDTOFromProduct(Product product) {

        return ProductResponseDto.builder()
                .productid(product.getProductId())
                .productname(product.getProductname())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
