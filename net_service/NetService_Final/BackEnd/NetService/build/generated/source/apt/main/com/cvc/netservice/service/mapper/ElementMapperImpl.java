package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Element;
import com.cvc.netservice.service.dto.ElementDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-23T15:37:07+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class ElementMapperImpl implements ElementMapper {

    @Override
    public ElementDTO toElementDTO(Element entity) {
        if ( entity == null ) {
            return null;
        }

        ElementDTO elementDTO = new ElementDTO();

        elementDTO.setId( entity.getId() );
        elementDTO.setProductId( entity.getProductId() );
        elementDTO.setGoodsId( entity.getGoodsId() );
        elementDTO.setElementId( entity.getElementId() );
        elementDTO.setQuantity( entity.getQuantity() );
        elementDTO.setCostPrice( entity.getCostPrice() );

        return elementDTO;
    }
}
