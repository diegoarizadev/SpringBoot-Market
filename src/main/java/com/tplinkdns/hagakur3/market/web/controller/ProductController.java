package com.tplinkdns.hagakur3.market.web.controller;

import com.tplinkdns.hagakur3.market.domain.Product;
import com.tplinkdns.hagakur3.market.domain.service.ProductService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Se garantiza que esta clase va ser un controlador de una API Rest
@RequestMapping("/products") //Path para consumir el servicio.
public class ProductController {
    @Autowired
    private ProductService productService; //Inyección dependecia.

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Integer productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }
}
