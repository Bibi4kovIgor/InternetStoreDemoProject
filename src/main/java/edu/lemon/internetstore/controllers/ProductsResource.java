package edu.lemon.internetstore.controllers;

import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class ProductsResource {

    private final ProductService productService;

    public ProductsResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductDto> getProductByName(
            @PathVariable(name = "name", required = false) String name
    ) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


}
