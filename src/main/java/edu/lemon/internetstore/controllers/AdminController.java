package edu.lemon.internetstore.controllers;

import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ModelAndView getProducts(){
        return new ModelAndView(
                "/pages/admin/admin-products",
                new ModelMap()
                        .addAttribute("products", productService.getAllData())
                        .addAttribute("productType", ProductDto.builder().build()));
    }

    @PostMapping("/add-product")
    public RedirectView addProduct(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "quantity") String quantity,
            @RequestParam(value = "price") String price,
            @RequestParam(value = "vendorCode") String vendorCode,
            @RequestParam(value = "description") String description){
        productService.addData(
                ProductDto.builder()
                        .name(name)
                        .quantity(Double.parseDouble(quantity))
                        .price(new BigDecimal(price))
                        .vendorCode(vendorCode)
                        .description(description)
                        .build());
        return new RedirectView("/admin/products");
    }
}
