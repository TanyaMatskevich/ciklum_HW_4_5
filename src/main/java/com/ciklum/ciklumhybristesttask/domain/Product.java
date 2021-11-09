package com.ciklum.ciklumhybristesttask.domain;

import com.ciklum.ciklumhybristesttask.enums.ProductStatus;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends DomainObject{

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public Product() {
    }

    public Product(String name, Integer price, ProductStatus productStatus, LocalDateTime created_at) {
        this.name = name;
        this.price = price;
        this.productStatus = productStatus;
        this.created_at = created_at;
    }

    public Product(String name, Integer price, ProductStatus productStatus) {
        this.name = name;
        this.price = price;
        this.productStatus = productStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(final ProductStatus productStatus) {
        this.productStatus = productStatus;
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
