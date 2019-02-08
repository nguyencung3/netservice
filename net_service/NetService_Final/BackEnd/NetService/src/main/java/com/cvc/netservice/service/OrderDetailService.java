package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.OrderDetailDTO;

public interface OrderDetailService {

    Boolean createOrder(OrderDetailDTO orderDetailDTO) throws Exception;
}
