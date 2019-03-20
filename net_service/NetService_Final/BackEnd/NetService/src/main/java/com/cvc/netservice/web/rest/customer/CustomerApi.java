package com.cvc.netservice.web.rest.customer;

import com.cvc.netservice.service.dto.CustomerDTO;
import com.cvc.netservice.service.dto.StaffDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/customer")
public interface CustomerApi {

    @ApiOperation(value = "Get All Customer by store", notes = "", response = CustomerDTO.class, tags = {"CUSTOMER",})
    @GetMapping("/getAll")
    ResponseEntity<List<CustomerDTO>> getAllCustomerByStore(@RequestParam Long storeId);
}
