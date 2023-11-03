package edu.lemon.internetstore.controllers;

import edu.lemon.internetstore.configure.ConfigMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ConfigMap configMap;

    @GetMapping(path = "/configs")
    public ModelAndView printConfigs(){
        return new ModelAndView(
                "/pages/index",
                new ModelMap()
                        .addAttribute("paypalPass", configMap.getPaypalPassword())
                        .addAttribute("paypalUrl", configMap.getPaypalUrl())
        );
    }

/*    private final ProductService productService;*/

/*    public MainController(ProductService productService) {
        this.productService = productService;
    }*/
    /*
    @GetMapping(path ={"/", "/{name}"})
    public String Greeting(@PathVariable(required = false, name = "name") String name) {
        return "Greetings " + name;
    }*/




}
