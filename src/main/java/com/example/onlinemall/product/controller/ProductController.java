package com.example.onlinemall.product.controller;

import com.example.onlinemall.product.entity.Product;
import com.example.onlinemall.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String findProducts(Model model) {
        List<Product> products = productService.findProducts();
        model.addAttribute("products", products);
        return "list";
    }
}
