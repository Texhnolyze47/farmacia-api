package com.texhnolyze.farmacia.repository;

import com.texhnolyze.farmacia.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {
}
