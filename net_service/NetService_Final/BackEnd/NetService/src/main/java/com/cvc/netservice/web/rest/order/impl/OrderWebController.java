package com.cvc.netservice.web.rest.order.impl;

import com.cvc.netservice.service.OrderService;
import com.cvc.netservice.service.dto.BillDTO;
import com.cvc.netservice.web.rest.order.OrderWebApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Controller
public class OrderWebController implements OrderWebApi {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<List<BillDTO>> getBillByDate(String fromDate, String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fromDate += " 00:00:00";
        toDate += " 00:00:00";
        LocalDateTime from = LocalDateTime.parse(fromDate, formatter);
        LocalDateTime to = LocalDateTime.parse(toDate, formatter);
        List<BillDTO> billDTOS = new LinkedList<>();
        try {
            billDTOS = orderService.getBillByDate(from, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(billDTOS);
    }
}
