package edu.lemon.internetstore.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "products", schema = "public")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

}