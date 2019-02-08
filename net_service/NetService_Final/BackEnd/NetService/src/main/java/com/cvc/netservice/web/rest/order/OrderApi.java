package com.cvc.netservice.web.rest.order;

import com.cvc.netservice.service.dto.OrderDTO;
import com.cvc.netservice.service.dto.RevenueByTypeDTO;
import com.cvc.netservice.service.dto.RevenueDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/order")
public interface OrderApi {

    @ApiOperation(value = "Create order return ID", notes = "", response = Long.class, tags = {"ORDER",})
    @PostMapping("/create")
    ResponseEntity<Long> create(@RequestBody OrderDTO orderDTO);

    @ApiOperation(value = "Get revenue By Date", notes = "", response = RevenueDTO.class, tags = {"ORDER",})
    @GetMapping("/get-revenue/date")
    ResponseEntity<RevenueDTO> getRevenueByDate(@RequestParam String dateTime);

    @ApiOperation(value = "Get Current revenue", notes = "", response = RevenueDTO.class, tags = {"ORDER",})
    @GetMapping("/get-revenue")
    ResponseEntity<RevenueDTO> getCurrentRevenue();

    @ApiOperation(value = "Get Current revenue", notes = "", response = RevenueDTO.class, tags = {"ORDER",})
    @GetMapping("/get-revenue/type-date")
    ResponseEntity<RevenueByTypeDTO> getRevenueByTypeAndDate(@RequestParam String from, @RequestParam String to, @RequestParam String[] revenueType);

}
