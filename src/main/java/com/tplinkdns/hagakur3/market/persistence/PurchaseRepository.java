package com.tplinkdns.hagakur3.market.persistence;

import com.tplinkdns.hagakur3.market.domain.Purchase;
import com.tplinkdns.hagakur3.market.domain.repository.PurchaseRepositoryDTO;
import com.tplinkdns.hagakur3.market.persistence.crud.CompraCrudRepository;
import com.tplinkdns.hagakur3.market.persistence.entity.Compra;
import com.tplinkdns.hagakur3.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Se indica a Spring que es un Bean o repositorio que se va a comunicar con la BD.
public class PurchaseRepository implements PurchaseRepositoryDTO {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;//Hablar en terminos del dominio

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
