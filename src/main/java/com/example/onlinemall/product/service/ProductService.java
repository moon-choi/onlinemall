package com.example.onlinemall.product.service;

import com.example.onlinemall.product.entity.Product;
import com.example.onlinemall.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findProducts() {
        return productRepository.findAll();
    }
}
