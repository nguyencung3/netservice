package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("select s.fullName from Staff s where s.id = ?1")
    String findNameStaff(Long id);

    Staff findByEmailAndPassword(String email, String password);



}
