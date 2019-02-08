package com.cvc.netservice.web.rest.order;

import com.cvc.netservice.service.dto.BillDTO;
import com.cvc.netservice.service.dto.RevenueDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/order-web")
public interface OrderWebApi {

    @ApiOperation(value = "Get Bill By Date", notes = "", response = RevenueDTO.class, tags = {"ORDER-WEB",})
    @GetMapping("/get-bill/date")
    ResponseEntity<List<BillDTO>> getBillByDate(@RequestParam String fromDate, @RequestParam String toDate);


}
