package com.tplinkdns.hagakur3.market.domain.repository;

import com.tplinkdns.hagakur3.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDTO {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
