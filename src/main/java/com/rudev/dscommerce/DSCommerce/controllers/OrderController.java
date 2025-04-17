package com.rudev.dscommerce.DSCommerce.controllers;
import com.rudev.dscommerce.DSCommerce.dto.OrderDTO;
import com.rudev.dscommerce.DSCommerce.dto.ProductDTO;
import com.rudev.dscommerce.DSCommerce.dto.ProductMinDTO;
import com.rudev.dscommerce.DSCommerce.entities.Product;
import com.rudev.dscommerce.DSCommerce.repositories.ProductRepository;
import com.rudev.dscommerce.DSCommerce.service.OrderService;
import com.rudev.dscommerce.DSCommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
    	OrderDTO dto = orderService.findById(id);
       return ResponseEntity.ok(dto);
    }
    
    @PreAuthorize("hasAnyRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@Valid @RequestBody OrderDTO OrderDTO){
       OrderDTO entity = orderService.insert(OrderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
       return ResponseEntity.created(uri).body(entity);
    }
}
