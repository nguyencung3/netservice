package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Customer;
import com.cvc.netservice.service.dto.CustomerDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-23T15:37:07+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toCustomerDTO(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( entity.getId() );
        customerDTO.setStoreId( entity.getStoreId() );
        customerDTO.setFirstName( entity.getFirstName() );
        customerDTO.setLastName( entity.getLastName() );
        customerDTO.setBirthDate( entity.getBirthDate() );
        customerDTO.setAddress( entity.getAddress() );
        customerDTO.setPhone( entity.getPhone() );
        customerDTO.setRewardPoints( entity.getRewardPoints() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setStoreId( dto.getStoreId() );
        customer.setFirstName( dto.getFirstName() );
        customer.setLastName( dto.getLastName() );
        customer.setBirthDate( dto.getBirthDate() );
        customer.setAddress( dto.getAddress() );
        customer.setPhone( dto.getPhone() );
        customer.setRewardPoints( dto.getRewardPoints() );

        return customer;
    }
}
