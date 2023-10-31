package edu.lemon.internetstore.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    @NonNull private String firstName;

    @Column(name = "last_name")
    @NonNull private String lastName;

    @Column(name = "phone")
    @NonNull private String phone;

    @Column(name = "login")
    @NonNull private String login;

    @Column(name = "email")
    @NonNull private String email;

    @Column(name = "password")
    @NonNull private String password;

    @Column(name = "birth_date")
    private Instant birthDate;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "document_id",
            referencedColumnName = "id")
    @NonNull private DocumentEntity document;


    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "customer")
    private Set<OrderEntity> order;

}