package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Goods, Long> {

    @Query("SELECT g from Goods g where g.basicUnitId is null and g.remove = false")
    List<Goods> findAllGoods();

    Goods findFirstByOrderByIdDesc();
}
