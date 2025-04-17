package com.rudev.dscommerce.DSCommerce.dto;

import com.rudev.dscommerce.DSCommerce.entities.OrderItem;

public class OrderItemDTO {
	private Long productId;
	private String name;
	private String imgUrl;
	private Double price;
	private Integer quantity;
	
	public OrderItemDTO() {}
	
	public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String imgUrl) {
		this.productId = productId;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		this.quantity = quantity;
		
	}

	public OrderItemDTO(OrderItem entity) {
		productId = entity.getProduct().getId();
		name = entity.getProduct().getName();
		imgUrl = entity.getProduct().getImgUrl();
		price = entity.getProduct().getPrice();
		quantity = entity.getQuantity();
	}

	public Long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}

}
