package com.tplinkdns.hagakur3.market.persistence.mapper;

import com.tplinkdns.hagakur3.market.domain.Category;
import com.tplinkdns.hagakur3.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring") //Interface mapeadora
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);//Se convierte una categoria en Category


    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true) //Se ignoran los productos del objeto de la clase categoria.
    Categoria toCategoria(Category category);//hace una conversion de Category a Categoria.


}
