package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Repository indica que la clase se encarga de interacturar con la base de datos
 * @Component: le indicamos que es un componente de spring.
 * @Class que da enforcada al dominio y no a una clase puntual que en este caso es producto
 * y desacoplas a que no dependa de una base de datos puntaul
 */
@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository crudRepository;

    @Autowired(required = false)
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) crudRepository.findAll();
        return mapper.toProducts(productos);
    }


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = crudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        //== el mapper se encarga de convertir en una lista de productos
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = crudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //== se hace un map que es una funcion de los opcionales, con funcion lambda, y retorna un optional
        return productos.map(prods -> mapper.toProducts(prods));
    }


    @Override
    public Optional<Product> getProduct(int productId) {
        return crudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    @Override
    public Product save(Product product) {
        //== hacemps conversion de product a producto
        Producto producto = mapper.toProducto(product);
        //== mapear
        return mapper.toProduct(crudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        crudRepository.deleteById(productId);
    }

}
