package edu.lemon.internetstore.model.dtos;

import java.time.Instant;

public record BasketDto(
        String id,
        CustomerDto customer,
        ProductDto product,
        double quantity,
        Instant createDate
) {}
