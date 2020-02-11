package com.ctcglobal.shippingapp.repo;

import com.ctcglobal.shippingapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findById(int id);
}
