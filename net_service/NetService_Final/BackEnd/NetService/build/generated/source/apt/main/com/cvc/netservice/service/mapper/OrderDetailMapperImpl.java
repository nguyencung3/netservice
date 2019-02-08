package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.OrderDetail;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-23T15:37:07+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetailDTO toOrderDetailDTO(OrderDetail entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setId( entity.getId() );
        orderDetailDTO.setOrderId( entity.getOrderId() );
        orderDetailDTO.setOrderStaffId( entity.getOrderStaffId() );
        orderDetailDTO.setOrderCustomerId( entity.getOrderCustomerId() );
        orderDetailDTO.setProductId( entity.getProductId() );
        orderDetailDTO.setUnitPrice( entity.getUnitPrice() );
        orderDetailDTO.setDiscount( entity.getDiscount() );
        orderDetailDTO.setQuantity( entity.getQuantity() );
        orderDetailDTO.setTypeOrder( entity.getTypeOrder() );
        orderDetailDTO.setProductName( entity.getProductName() );

        return orderDetailDTO;
    }

    @Override
    public OrderDetail toEntity(OrderDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setId( dto.getId() );
        orderDetail.setOrderId( dto.getOrderId() );
        orderDetail.setOrderStaffId( dto.getOrderStaffId() );
        orderDetail.setOrderCustomerId( dto.getOrderCustomerId() );
        orderDetail.setProductId( dto.getProductId() );
        orderDetail.setUnitPrice( dto.getUnitPrice() );
        orderDetail.setDiscount( dto.getDiscount() );
        orderDetail.setQuantity( dto.getQuantity() );
        orderDetail.setTypeOrder( dto.getTypeOrder() );
        orderDetail.setProductName( dto.getProductName() );

        return orderDetail;
    }
}
