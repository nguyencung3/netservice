package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Customer;
import com.cvc.netservice.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

    CustomerDTO toCustomerDTO(Customer entity);

    Customer toEntity(CustomerDTO dto);
}
