package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getListCustomerByStore(Long storeId);
}
