package com.ciklum.ciklumhybristesttask.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends DomainObject{

    @Column(name = "user_id")
    private int user_id;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order(final int user_id, final String status, final LocalDateTime created_at) {
        this.user_id = user_id;
        this.status = status;
        this.created_at = created_at;
    }

    public Order() {

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(final int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(final LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
