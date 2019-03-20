package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c.lastName from Customer c where c.id = ?1")
    String findNameCustomer(Long id);

    List<Customer> findByStoreId(Long storeId);
}
