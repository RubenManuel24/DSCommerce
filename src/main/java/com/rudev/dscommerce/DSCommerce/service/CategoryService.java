package com.rudev.dscommerce.DSCommerce.service;
import com.rudev.dscommerce.DSCommerce.dto.CategoryDTO;
import com.rudev.dscommerce.DSCommerce.entities.Category;
import com.rudev.dscommerce.DSCommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> listCategory = categoryRepository.findAll();
        return listCategory.stream().map(category -> new CategoryDTO(category)).toList();
    }

}
