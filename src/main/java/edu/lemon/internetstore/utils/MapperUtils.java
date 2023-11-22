package edu.lemon.internetstore.utils;

import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.model.entities.ProductEntity;

public class MapperUtils {

    public static ProductDto productEntityToDto(ProductEntity productEntity) {
        return ProductDto.builder()
                .id(productEntity.getId().toString())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .name(productEntity.getName())
                .vendorCode(productEntity.getVendorCode())
                .description(productEntity.getDescription())
                .build();
    }

    public static ProductEntity productDtoToEntity(ProductDto productsDto) {
        return ProductEntity.builder()
                .name(productsDto.name())
                .price(productsDto.price())
                .description(productsDto.description())
                .quantity(productsDto.quantity())
                .vendorCode(productsDto.vendorCode())
                .build();
    }

}
