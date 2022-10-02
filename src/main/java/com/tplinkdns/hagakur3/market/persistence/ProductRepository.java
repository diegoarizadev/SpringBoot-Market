package com.tplinkdns.hagakur3.market.persistence;

import com.tplinkdns.hagakur3.market.domain.Product;
import com.tplinkdns.hagakur3.market.persistence.crud.ProductoCrudRepository;
import com.tplinkdns.hagakur3.market.persistence.entity.Producto;
import com.tplinkdns.hagakur3.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Como la clase esta interactua con la base de datos..
public class ProductRepository implements com.tplinkdns.hagakur3.market.domain.repository.ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prods -> productMapper.toProduct(prods));
    }

    @Override
    public Product save(Product product){
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
