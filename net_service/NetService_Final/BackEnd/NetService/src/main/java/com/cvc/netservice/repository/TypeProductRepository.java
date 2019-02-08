package com.cvc.netservice.repository;

import com.cvc.netservice.domain.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {

    TypeProduct findFirstByOrderByIdDesc();
}
