package com.rudev.dscommerce.DSCommerce.service;
import com.rudev.dscommerce.DSCommerce.dto.OrderDTO;
import com.rudev.dscommerce.DSCommerce.entities.Order;
import com.rudev.dscommerce.DSCommerce.repositories.OrderRepository;
import com.rudev.dscommerce.DSCommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
       Optional<Order> product = orderRepository.findById(id);
       Order pd = product.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
       OrderDTO dto = new OrderDTO(pd);
       return dto;
    }

   


}
