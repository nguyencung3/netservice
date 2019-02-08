package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Element;
import com.cvc.netservice.domain.Order;
import com.cvc.netservice.service.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderDetailMapper.class})
public interface OrderMapper {

    OrderDTO toOrderDTO(Order entity);

    Order toEntity(OrderDTO dto);
}
