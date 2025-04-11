package com.rudev.dscommerce.DSCommerce.controllers;
import com.rudev.dscommerce.DSCommerce.dto.ProductDTO;
import com.rudev.dscommerce.DSCommerce.entities.Product;
import com.rudev.dscommerce.DSCommerce.repositories.ProductRepository;
import com.rudev.dscommerce.DSCommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
       ProductDTO dto = productService.findById(id);
       return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "")  String name,
            Pageable pageable){
        Page<ProductDTO> listproduct = productService.findAll(name, pageable);
        return ResponseEntity.ok(listproduct);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO productDTO){
       ProductDTO entity = productService.insert(productDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
       return ResponseEntity.created(uri).body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable Long id, @RequestBody ProductDTO productDTO){

        ProductDTO entity = productService.update(id, productDTO);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
