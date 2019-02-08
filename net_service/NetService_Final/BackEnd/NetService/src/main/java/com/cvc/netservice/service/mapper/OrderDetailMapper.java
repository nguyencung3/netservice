package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.OrderDetail;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface OrderDetailMapper {


    OrderDetailDTO toOrderDetailDTO(OrderDetail entity);

    OrderDetail toEntity(OrderDetailDTO dto);
}
