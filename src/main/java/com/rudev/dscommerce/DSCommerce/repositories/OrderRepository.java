package com.rudev.dscommerce.DSCommerce.repositories;
import com.rudev.dscommerce.DSCommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
