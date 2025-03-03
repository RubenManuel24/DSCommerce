package com.rudev.dscommerce.DSCommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product_order")
public class OrderItem {

    private Integer quanity;
    private Double price;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    public OrderItem() {}

    public OrderItem(Product product, Order order, Integer quanity, Double price) {
        id.setProduct(product);
        id.setOrder(order);
        this.quanity = quanity;
        this.price = price;
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
         id.setProduct(product);
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }
}
