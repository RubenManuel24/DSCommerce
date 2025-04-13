package com.rudev.dscommerce.DSCommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.rudev.dscommerce.DSCommerce.entities.Category;
import com.rudev.dscommerce.DSCommerce.entities.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @Size(min = 2, max = 80, message = "O nome deve ter no mínimo 3 carácteres e no máximo 80")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min = 3, message = "O description deve ter no mínimo 3 carácteres")
    private String description;

    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgUrl;
    
    @NotEmpty(message = "Deve ter categoria")
    public List<CategotyDTO> categories = new ArrayList<CategotyDTO>();

    public ProductDTO() {}

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        for(Category cat : product.getCategories()) {
        	categories.add(new CategotyDTO(cat));
        }
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

	public List<CategotyDTO> getCategories() {
		return categories;
	}
    
}
