package com.tplinkdns.hagakur3.market.domain.service;


import com.tplinkdns.hagakur3.market.domain.Product;
import com.tplinkdns.hagakur3.market.domain.repository.ProductRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //o @Component,. Service agrega una diferenciación semantica de la clase (es un servicio)
public class ProductService {
    @Autowired
    private ProductRepositoryDTO productRepository; //Se implementa la interface

    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> { //GetProduct se valida que el producto exista.
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
