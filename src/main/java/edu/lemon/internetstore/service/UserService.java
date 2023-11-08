package edu.lemon.internetstore.service;

import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.repositories.ProductRepository;
import edu.lemon.internetstore.utils.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final ProductRepository productRepository;

    public UserService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(MapperUtils::productEntityToDto)
                .toList();
    }
}
