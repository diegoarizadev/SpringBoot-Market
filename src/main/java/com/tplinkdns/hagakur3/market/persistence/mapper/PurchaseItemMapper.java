package com.tplinkdns.hagakur3.market.persistence.mapper;

import com.tplinkdns.hagakur3.market.domain.PurchaseItem;
import com.tplinkdns.hagakur3.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})//Objetivo es poder ser inyectable desde otras clases o implementaciones
public interface PurchaseItemMapper {

    //@Mapping(source = "total", target = "total"), //no se agrega porque el source es igual al mapper
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
           @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration //Esta conversión hace le mappinmg inverso del objeto anterior.
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);

}
