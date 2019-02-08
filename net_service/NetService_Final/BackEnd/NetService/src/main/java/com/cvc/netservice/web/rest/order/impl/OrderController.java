package com.cvc.netservice.web.rest.order.impl;

import com.cvc.netservice.service.OrderService;
import com.cvc.netservice.service.dto.OrderDTO;
import com.cvc.netservice.service.dto.RevenueByTypeDTO;
import com.cvc.netservice.service.dto.RevenueDTO;
import com.cvc.netservice.web.rest.order.OrderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class OrderController implements OrderApi {

    @Autowired
    private OrderService orderService;

    //Create not success return ID null
    @Override
    public ResponseEntity<Long> create(@RequestBody OrderDTO orderDTO) {
        Long id;
        try {
            id = orderService.createOrder(orderDTO);
        } catch (Exception e) {
            id = null;
        }
        return ResponseEntity.ok(id);
    }

    @Override
    public ResponseEntity<RevenueDTO> getRevenueByDate(String dateTime) {
        dateTime += " 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        RevenueDTO revenueDTO = new RevenueDTO();
        try {
            revenueDTO = orderService.getRevenueByDate(LocalDateTime.parse(dateTime, formatter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(revenueDTO);
    }

    @Override
    public ResponseEntity<RevenueDTO> getCurrentRevenue() {
        RevenueDTO revenueDTO = new RevenueDTO();
        try {
            revenueDTO = orderService.getRevenueByDate(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(revenueDTO);
    }

    @Override
    public ResponseEntity<RevenueByTypeDTO> getRevenueByTypeAndDate(@RequestParam String from, @RequestParam String to, @RequestParam String[] revenueType) {
        RevenueByTypeDTO revenueDTO = new RevenueByTypeDTO();
        from += " 00:00:00";
        to += " 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            revenueDTO = orderService.getRevenueByTypeAndDate(LocalDateTime.parse(from, formatter),LocalDateTime.parse(to, formatter), revenueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(revenueDTO);
    }

}
