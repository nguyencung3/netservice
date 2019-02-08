package com.cvc.netservice.web.rest.order.impl;

import com.cvc.netservice.service.OrderDetailService;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import com.cvc.netservice.web.rest.order.OrderDetailApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderDetailController  implements OrderDetailApi{

    @Autowired
    private OrderDetailService detailService;

    @Override
    public ResponseEntity<Boolean> create(@RequestBody OrderDetailDTO orderDetailDTO) {
        Boolean result = true;
        try {
            detailService.createOrder(orderDetailDTO);
        } catch (Exception e) {
            result = false;
        }
        return ResponseEntity.ok(result);
    }
}
