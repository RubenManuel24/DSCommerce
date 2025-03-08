package com.rudev.dscommerce.DSCommerce.repositories;

import com.rudev.dscommerce.DSCommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
