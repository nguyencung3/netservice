package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.TypeProduct;
import com.cvc.netservice.service.dto.TypeProductDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-23T15:37:07+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class TypeProductMapperImpl implements TypeProductMapper {

    @Override
    public TypeProductDTO toProductDTO(TypeProduct entity) {
        if ( entity == null ) {
            return null;
        }

        TypeProductDTO typeProductDTO = new TypeProductDTO();

        typeProductDTO.setId( entity.getId() );
        typeProductDTO.setNameType( entity.getNameType() );
        typeProductDTO.setDescription( entity.getDescription() );

        return typeProductDTO;
    }

    @Override
    public TypeProduct toEntity(TypeProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TypeProduct typeProduct = new TypeProduct();

        typeProduct.setId( dto.getId() );
        typeProduct.setNameType( dto.getNameType() );
        typeProduct.setDescription( dto.getDescription() );

        return typeProduct;
    }
}
