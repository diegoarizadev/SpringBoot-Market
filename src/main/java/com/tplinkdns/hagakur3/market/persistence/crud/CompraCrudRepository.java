package com.tplinkdns.hagakur3.market.persistence.crud;

import com.tplinkdns.hagakur3.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);
}
