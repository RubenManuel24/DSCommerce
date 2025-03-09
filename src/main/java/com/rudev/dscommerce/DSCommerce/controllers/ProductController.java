package com.rudev.dscommerce.DSCommerce.controllers;

import com.rudev.dscommerce.DSCommerce.dto.ProductDTO;
import com.rudev.dscommerce.DSCommerce.entities.Product;
import com.rudev.dscommerce.DSCommerce.repositories.ProductRepository;
import com.rudev.dscommerce.DSCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
       ProductDTO dto = productService.findById(id);
       return dto;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<ProductDTO> listproduct = productService.findAll(pageable);
        return listproduct;
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO){
       ProductDTO entity = productService.insert(productDTO);
       return entity;
    }

}
