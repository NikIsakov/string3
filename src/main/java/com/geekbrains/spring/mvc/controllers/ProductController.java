package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Box;
import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteBoxById(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/boxes/all";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }
}
