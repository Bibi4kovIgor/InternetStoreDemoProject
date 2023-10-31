package edu.lemon.internetstore.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    @NonNull private String name;

    @Column(name = "organisation_name")
    @NonNull private String organisationName;

    @Column(name = "email")
    @NonNull private String email;

    @Column(name = "password")
    @NonNull private String password;

    @Column(name = "phone")
    @NonNull private String phone;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "document_id",
            referencedColumnName = "id")
    @NonNull private DocumentEntity document;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_suppliers",
            joinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    @NonNull private Set<ProductEntity> products;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
//    private Set<CategoriesEntity> categories;
//
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
//    @NotNull Set<SuppliersEntity> suppliers;

}