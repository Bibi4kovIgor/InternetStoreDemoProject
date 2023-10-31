package edu.lemon.internetstore.model.dtos;

import lombok.Builder;

import java.time.Instant;

@Builder
public record OrderDto(
        String id,
        CustomerDto customerDto,
        ProductDto productDao,
        int quantity,
        Instant orderDate){}
