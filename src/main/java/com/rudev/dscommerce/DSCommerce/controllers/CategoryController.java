package com.rudev.dscommerce.DSCommerce.controllers;
import com.rudev.dscommerce.DSCommerce.dto.CategoryDTO;
import com.rudev.dscommerce.DSCommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> listCategory = categoryService.findAll();
        return ResponseEntity.ok(listCategory);
    }
}
