package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
    //@Query(value = "select  * from productos where id_categoria=?",nativeQuery = true);
    List<Producto>findByIdCategoriaOrderByNombreAsc(int idCategoria);
    //== (int cantidadStock, boolean estado) las variables se tienen que llamar que igual de  la clases

    /**
     *
     * @param cantidadStock
     * @param estado
     * @return obtener los productos que tienen menos stock y donde el estado
     */
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
