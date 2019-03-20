package com.cvc.netservice.web.rest.customer.impl;

import com.cvc.netservice.service.CustomerService;
import com.cvc.netservice.service.dto.CustomerDTO;
import com.cvc.netservice.web.rest.customer.CustomerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<List<CustomerDTO>> getAllCustomerByStore(Long storeId) {
        List<CustomerDTO> customerDTOS;
        customerDTOS = customerService.getListCustomerByStore(storeId);
        return ResponseEntity.ok(customerDTOS);
    }
}
