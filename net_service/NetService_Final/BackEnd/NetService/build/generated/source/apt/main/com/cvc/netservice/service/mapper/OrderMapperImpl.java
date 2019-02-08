package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Order;
import com.cvc.netservice.domain.OrderDetail;
import com.cvc.netservice.service.dto.OrderDTO;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-23T15:37:07+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDTO toOrderDTO(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( entity.getId() );
        orderDTO.setCustomerId( entity.getCustomerId() );
        orderDTO.setCustomerStoreId( entity.getCustomerStoreId() );
        orderDTO.setStaffId( entity.getStaffId() );
        orderDTO.setOrderDate( entity.getOrderDate() );
        orderDTO.setStatus( entity.getStatus() );
        List<OrderDetailDTO> list = orderDetailListToOrderDetailDTOList( entity.getOrderDetails() );
        if ( list != null ) {
            orderDTO.setOrderDetails( list );
        }

        return orderDTO;
    }

    @Override
    public Order toEntity(OrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setCustomerId( dto.getCustomerId() );
        order.setCustomerStoreId( dto.getCustomerStoreId() );
        order.setStaffId( dto.getStaffId() );
        order.setOrderDate( dto.getOrderDate() );
        order.setStatus( dto.getStatus() );
        List<OrderDetail> list = orderDetailDTOListToOrderDetailList( dto.getOrderDetails() );
        if ( list != null ) {
            order.setOrderDetails( list );
        }

        return order;
    }

    protected List<OrderDetailDTO> orderDetailListToOrderDetailDTOList(List<OrderDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetailDTO> list_ = new ArrayList<OrderDetailDTO>();
        for ( OrderDetail orderDetail : list ) {
            list_.add( orderDetailMapper.toOrderDetailDTO( orderDetail ) );
        }

        return list_;
    }

    protected List<OrderDetail> orderDetailDTOListToOrderDetailList(List<OrderDetailDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetail> list_ = new ArrayList<OrderDetail>();
        for ( OrderDetailDTO orderDetailDTO : list ) {
            list_.add( orderDetailMapper.toEntity( orderDetailDTO ) );
        }

        return list_;
    }
}
