package com.tplinkdns.hagakur3.market.web.controller;

import com.tplinkdns.hagakur3.market.domain.Product;
import com.tplinkdns.hagakur3.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //Se garantiza que esta clase va ser un controlador de una API Rest
@RequestMapping("/products") //Path para consumir el servicio.
public class ProductController {
    @Autowired
    private ProductService productService; //Inyección dependecia.

    public List<Product> getAll() {
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productService.save(product);
    }

    public boolean delete(int productId) {
        return productService.delete(productId);
    }
}
