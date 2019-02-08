package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.BillDTO;
import com.cvc.netservice.service.dto.OrderDTO;
import com.cvc.netservice.service.dto.RevenueByTypeDTO;
import com.cvc.netservice.service.dto.RevenueDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    Long createOrder(OrderDTO orderDTO) throws Exception;

    RevenueDTO getRevenueByDate(LocalDateTime dateTime) throws Exception;

    RevenueByTypeDTO getRevenueByTypeAndDate(LocalDateTime from, LocalDateTime to, String[] type) throws Exception;

    List<BillDTO> getBillByDate(LocalDateTime from, LocalDateTime to) throws Exception;


}
