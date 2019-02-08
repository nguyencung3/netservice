package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.TypeProduct;
import com.cvc.netservice.service.dto.TypeProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TypeProductMapper {

    TypeProductDTO toProductDTO(TypeProduct entity);

    TypeProduct toEntity(TypeProductDTO dto);
}
