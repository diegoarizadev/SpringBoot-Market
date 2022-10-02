package com.tplinkdns.hagakur3.market.persistence.crud;

import com.tplinkdns.hagakur3.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //CrudRepository <Table o clase, Tipo de dato de la PK>

    List<Producto> findByidCategoria(int idCategoria); // QUERY METHOD, busca todos los productos por IdCategoria


    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); //QUERY METHOD, busca y ordena los productos por id de categoria

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado); //QUERY METHOD, recuperar productos escasos y que mas se venden


    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getIdCategoria(int idCategoria); //Construcción de una consulta SIN QUERY METHOD


}
