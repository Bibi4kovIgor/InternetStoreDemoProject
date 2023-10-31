package edu.lemon.internetstore.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class BasketPkEntity implements Serializable {
    @NonNull private final UUID basketId;
    @NonNull private final UUID customerId;
    @NonNull private final UUID productId;
}
