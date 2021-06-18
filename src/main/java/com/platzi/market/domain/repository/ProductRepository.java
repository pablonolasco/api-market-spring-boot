package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;
import java.util.List;
import java.util.Optional;
// repository de dominio
public interface ProductRepository {
    // metodos del ProductoRepository para conectar a la bd con esto se colocan las reglas para ingresar a la bd
    // y solo exponer lo que queremos
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
