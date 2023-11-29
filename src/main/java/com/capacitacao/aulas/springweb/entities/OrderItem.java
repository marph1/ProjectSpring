package com.capacitacao.aulas.springweb.entities;

import com.capacitacao.aulas.springweb.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "table_orderItem")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();;
    private Integer quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }
    @JsonIgnore
    public Product getPrduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public OrderItemPk getId() {
        return id;
    }

    public void setId(OrderItemPk id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public double getSubTotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
