package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {
}
