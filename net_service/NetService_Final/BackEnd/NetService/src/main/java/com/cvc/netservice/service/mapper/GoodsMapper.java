package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Goods;
import com.cvc.netservice.service.dto.GoodsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface GoodsMapper {

    GoodsDTO toGoodsDTO(Goods entity);

    Goods toEntity(GoodsDTO dto);
}
