package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // convertir una categoria en un category
    @Mappings({
        @Mapping(source="idCategoria",target="categoryId"),
        @Mapping(source="descripcion",target="category"),
        @Mapping(source="estado",target="active")
    })
    Category toCategory(Categoria categoria);

    /**
     *
     * @param category
     * @return indica que debe hacer la conversion inversa a la que esta arriba
     */
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
