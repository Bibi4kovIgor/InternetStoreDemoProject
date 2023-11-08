package edu.lemon.internetstore.controllers;

import edu.lemon.internetstore.configure.ConfigMap;
import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    private final ConfigMap configMap;
    private final UserService userService;

    public MainController(ConfigMap configMap, UserService userService) {
        this.configMap = configMap;
        this.userService = userService;
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
                        .addAttribute("products", userService.getAllProducts())
                        .addAttribute("productType", ProductDto.builder().build()));
    }

}
