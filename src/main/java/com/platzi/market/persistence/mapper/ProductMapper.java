package com.platzi.market.persistence.mapper;


import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//== se agrega porque Category tiene su propio mapper

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    // convertir un producto en un product
    @Mappings({
            // fuente, destino
        @Mapping(source="idProducto",target="productId"),
        @Mapping(source="nombre",target="name"),
        @Mapping(source="idCategoria",target="categoryId"),
        @Mapping(source="precioVenta",target="price"),
        @Mapping(source="cantidadStock",target="stock"),
        @Mapping(source="estado",target="active"),
        @Mapping(source="categoria",target="category")
    })
    Product toProduct(Producto producto);
    List<Product>toProducts(List<Producto> productos);
    /**
     *
     * @param product
     * @return indica que debe hacer la conversion inversa a la que esta arriba con base al mapeo
     */
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Producto toProducto(Product product);
}
