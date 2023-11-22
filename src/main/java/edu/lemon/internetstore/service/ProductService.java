package edu.lemon.internetstore.service;

import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.repositories.ProductRepository;
import edu.lemon.internetstore.utils.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(MapperUtils::productEntityToDto)
                .toList();
    }

    public ProductDto getProductByName(String productName) {
        return MapperUtils.productEntityToDto(productRepository.findByName(productName));
    }
}
