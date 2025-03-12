package com.rudev.dscommerce.DSCommerce.service;

import com.rudev.dscommerce.DSCommerce.dto.ProductDTO;
import com.rudev.dscommerce.DSCommerce.entities.Product;
import com.rudev.dscommerce.DSCommerce.repositories.ProductRepository;
import com.rudev.dscommerce.DSCommerce.service.exceptions.DataIntegrityException;
import com.rudev.dscommerce.DSCommerce.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
       Optional<Product> product = productRepository.findById(id);
       Product pd = product.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
       ProductDTO dto = new ProductDTO(pd);
       return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> listProduct = productRepository.findAll(pageable);
        return listProduct.map(product -> new ProductDTO(product));
    }

   @Transactional
    public ProductDTO insert(ProductDTO productDTO){

        Product entity = new Product();

        copyDTOtoEntity(entity, productDTO);

       entity.setName(productDTO.getName());
       entity.setDescription(productDTO.getDescription());
       entity.setImgUrl(productDTO.getImgUrl());
       entity.setPrice(productDTO.getPrice());

       entity = productRepository.save(entity);

       return new ProductDTO(entity);
   }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO){
      try{
          Product entity = productRepository.getReferenceById(id);
          copyDTOtoEntity(entity, productDTO);
          entity = productRepository.save(entity);
          return new ProductDTO(entity);
      }catch (EntityNotFoundException e){

          throw new ResourceNotFoundException("Recurso não encontrado");

      }

   }

   @Transactional(propagation = Propagation.SUPPORTS)
   public void deleteById(Long id){
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            productRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
          throw new DataIntegrityException("Falha de integridade referêncial");
        }
    }

    private void copyDTOtoEntity(Product entity, ProductDTO productDTO) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setImgUrl(productDTO.getImgUrl());
        entity.setPrice(productDTO.getPrice());
    }



}
