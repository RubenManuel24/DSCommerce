package com.rudev.dscommerce.DSCommerce.dto;

import com.rudev.dscommerce.DSCommerce.entities.Product;
import jakarta.persistence.Column;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO() {}

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
