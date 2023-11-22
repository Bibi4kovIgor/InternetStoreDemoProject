package edu.lemon.internetstore.controllers;

import edu.lemon.internetstore.configure.ConfigMap;
import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    private final ConfigMap configMap;
    private final ProductService productService;

    public MainController(ConfigMap configMap, ProductService productService) {
        this.configMap = configMap;
        this.productService = productService;
    }

    @GetMapping(path = "/configs")
    public ModelAndView printConfigs(){
        return new ModelAndView(
                "/pages/index",
                new ModelMap()
                        .addAttribute("paypalPass", configMap.getPaypalPassword())
                        .addAttribute("paypalUrl", configMap.getPaypalUrl())
        );
    }

    @GetMapping(path = "/products")
    public ModelAndView getAllUsers(){
        return new ModelAndView(
                "/pages/products",
                new ModelMap()
                        .addAttribute("products", productService.getAllProducts())
                        .addAttribute("productType", ProductDto.builder().build()));
    }

    @GetMapping(path = "/products-table")
    public String getAllProducts(){
        return "/pages/index.html";
    }

}
