package com.tplinkdns.hagakur3.market.persistence;

import com.tplinkdns.hagakur3.market.persistence.crud.ProductoCrudRepository;
import com.tplinkdns.hagakur3.market.persistence.entity.Producto;

import java.util.List;

public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
