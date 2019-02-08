package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.OrderDetail;
import com.cvc.netservice.repository.OrderDetailRepository;
import com.cvc.netservice.service.OrderDetailService;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import com.cvc.netservice.service.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    private final OrderDetailMapper orderDetailMapper;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderDetailMapper orderDetailMapper) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailMapper = orderDetailMapper;
    }

    @Override
    public Boolean createOrder(OrderDetailDTO orderDetailDTO) throws Exception {
        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDTO);
        orderDetailRepository.save(orderDetail);
        return true;
    }
}
