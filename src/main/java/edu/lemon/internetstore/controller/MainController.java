package edu.lemon.internetstore.controller;

import edu.lemon.internetstore.model.ProductsEntity;
import edu.lemon.internetstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    private ProductRepository productRepository;

/*
    @GetMapping(path ={"/", "/{name}"})
    public String Greeting(@PathVariable(required = false, name = "name") String name) {
        return "Greetings " + name;
    }*/

    @GetMapping(path = "/all-products")
    public String getProducts(){
        return productRepository.findAll().stream().map(String::valueOf).collect(Collectors.joining(","));
    }


    @PostMapping(path = "/add-test-product")
    public void addProduct() {
        final String productName = "test";
        final String vendorCode = "test";
        final int  quantity = 1;
        final boolean availability = true;
        final BigDecimal price = new BigDecimal("123.55");
        final String description = "Some description";
        productRepository.save(
                ProductsEntity.builder()
                    .availability(availability)
                    .description(description)
                    .price(price)
                    .quantity(quantity)
                    .vendorCode(vendorCode)
                    .name(productName)
                .build());

    }


}
