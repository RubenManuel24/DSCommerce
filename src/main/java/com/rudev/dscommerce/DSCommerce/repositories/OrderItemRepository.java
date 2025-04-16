package com.rudev.dscommerce.DSCommerce.repositories;
import com.rudev.dscommerce.DSCommerce.entities.OrderItem;
import com.rudev.dscommerce.DSCommerce.entities.OrderItemPK;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
