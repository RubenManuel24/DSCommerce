package com.rudev.dscommerce.DSCommerce.service;
import com.rudev.dscommerce.DSCommerce.dto.OrderDTO;
import com.rudev.dscommerce.DSCommerce.dto.OrderItemDTO;
import com.rudev.dscommerce.DSCommerce.entities.Order;
import com.rudev.dscommerce.DSCommerce.entities.OrderItem;
import com.rudev.dscommerce.DSCommerce.entities.OrderStatus;
import com.rudev.dscommerce.DSCommerce.entities.Product;
import com.rudev.dscommerce.DSCommerce.entities.User;
import com.rudev.dscommerce.DSCommerce.repositories.OrderItemRepository;
import com.rudev.dscommerce.DSCommerce.repositories.OrderRepository;
import com.rudev.dscommerce.DSCommerce.repositories.ProductRepository;
import com.rudev.dscommerce.DSCommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
     private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
       Optional<Order> product = orderRepository.findById(id);
       Order pd = product.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
       OrderDTO dto = new OrderDTO(pd);
       authService.validateSelfOrAdmin(dto.getClient().getId());
       return dto;
    }
    
    @Transactional
	public OrderDTO insert(OrderDTO orderDTO) {
		
        Order order = new Order();
        
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        
        User user = userService.autheticated();
        
        order.setClient(user);
        
        for(OrderItemDTO itemDTO : orderDTO.getItems()) {
        	Product prodct = productRepository.getReferenceById(itemDTO.getProductId());
        	OrderItem item = new OrderItem(prodct, order, itemDTO.getQuantity(), itemDTO.getPrice());
        	
        	order.getItems().add(item);
        }
        
        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());
        
        
		return new OrderDTO(order);
	}
}
