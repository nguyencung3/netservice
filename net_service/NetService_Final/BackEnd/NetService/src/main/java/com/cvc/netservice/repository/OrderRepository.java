package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findFirstByOrderByIdDesc();

   @Query("SELECT o FROM Order o where o.orderDate like ?1")
    List<Order> findByOrderDateContains(LocalDateTime localDateTime);


    List<Order> findByOrderDateBetween(LocalDateTime from,LocalDateTime to);

//    @Query("select case when (count(e) > 0) then true else false end from Entity e where e.dateTime = :date")
//    public boolean check(@Param("date") LocalDate date);
}
