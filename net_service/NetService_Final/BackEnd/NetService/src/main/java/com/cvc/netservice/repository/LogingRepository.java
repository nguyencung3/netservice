package com.cvc.netservice.repository;

import com.cvc.netservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface LogingRepository extends JpaRepository<User,Long> {

}
