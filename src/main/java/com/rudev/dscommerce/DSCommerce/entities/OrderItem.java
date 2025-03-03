package com.rudev.dscommerce.DSCommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    private Integer quantity;
    private Double price;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    public OrderItem() {}

    public OrderItem(Product product, Order order, Integer quantity, Double price) {
        id.setProduct(product);
        id.setOrder(order);
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
