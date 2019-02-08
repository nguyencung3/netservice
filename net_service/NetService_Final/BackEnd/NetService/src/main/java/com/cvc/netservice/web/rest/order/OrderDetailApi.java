package com.cvc.netservice.web.rest.order;

import com.cvc.netservice.service.dto.OrderDetailDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order-detail")
public interface OrderDetailApi {

    @ApiOperation(value = "Create Order Detail", notes = "", response = Boolean.class, tags = {"ORDER",})
    @PostMapping("/create")
    ResponseEntity<Boolean> create(@RequestBody OrderDetailDTO orderDetailDTO);
}
