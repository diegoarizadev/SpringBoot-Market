package com.tplinkdns.hagakur3.market.persistence.crud;

import com.tplinkdns.hagakur3.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //CrudRepository <Table o clase, Tipo de dato de la PK>



}
