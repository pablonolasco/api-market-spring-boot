package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

/**
 * contrato de la interface
 */
public interface PurchaseRepository {
    /**
     *
     * @return todas las compras
     */
    List<Purchase> getAll();

    /**
     *
     * @param clientId
     * @return compras del cliente
     */
    Optional<List<Purchase>> getByClient(String clientId);

    /**
     *
     * @param purchase objeto compra
     * @return compra guardada
     */
    Purchase save(Purchase purchase);
}
