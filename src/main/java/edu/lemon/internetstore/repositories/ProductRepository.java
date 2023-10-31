package edu.lemon.internetstore.repositories;

import edu.lemon.internetstore.model.entities.ProductEntity;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    @NonNull List<ProductEntity> findAll();

    List<ProductEntity> findByName(String name);

    @Override
    @Transactional
    ProductEntity save(@NonNull ProductEntity entity);
}
