package com.api.teste.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.teste.demo.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
    @Query("SELECT o FROM Order o WHERE o.status =:status")
    List<Order> findOrdersByStatus(@Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
        List<Order> findOrdersBetweenDates(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
