package com.cvc.netservice.service.impl;

import com.cvc.netservice.repository.CustomerRepository;
import com.cvc.netservice.service.CustomerService;
import com.cvc.netservice.service.dto.CustomerDTO;
import com.cvc.netservice.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getListCustomerByStore(Long storeId) {
        return customerRepository.findByStoreId(storeId).stream()
                .map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }
}
