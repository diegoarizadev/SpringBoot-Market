package com.tplinkdns.hagakur3.market.persistence;

import com.tplinkdns.hagakur3.market.persistence.crud.ProductoCrudRepository;
import com.tplinkdns.hagakur3.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Como la clase esta interactua con la base de datos..
public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByidCategoria(idCategoria);
    }

    public List<Producto> getByCategoriaOrderByNombreASC(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public List<Producto> getByCategoriaNoMethods(int idCategoria){
        return productoCrudRepository.getIdCategoria(idCategoria);
    }

    public Optional<List<Producto>> getProductosEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProduct0(int idProduct){
        return productoCrudRepository.findById(idProduct);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
