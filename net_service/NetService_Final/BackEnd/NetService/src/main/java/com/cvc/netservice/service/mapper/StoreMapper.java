package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Store;
import com.cvc.netservice.service.dto.StoreDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface StoreMapper {

    StoreDTO toStoreDTO(Store entity);

    Store toEntity(StoreDTO dto);
}
