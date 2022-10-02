package com.tplinkdns.hagakur3.market.persistence;

import com.tplinkdns.hagakur3.market.persistence.crud.ProductoCrudRepository;
import com.tplinkdns.hagakur3.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.finByIdCategoria(idCategoria);
    }

    public List<Producto> getByCategoriaOrderByNombreASC(int idCategoria){
        return productoCrudRepository.finByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public List<Producto> getByCategoriaNoMethods(int idCategoria){
        return productoCrudRepository.getIdCategoria(idCategoria);
    }

    public Optional<List<Producto>> getProductosEscasos(int cantidad){
        return productoCrudRepository.finByIdCantidadStockLessThanAndEstado(cantidad, true);
    }
}
