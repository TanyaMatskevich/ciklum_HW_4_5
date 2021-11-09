package com.ciklum.ciklumhybristesttask.repo;

import com.ciklum.ciklumhybristesttask.domain.Order;
import com.ciklum.ciklumhybristesttask.dto.OrderWithProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select o.id as orderId, p.price*oi.quantity as totalPrice, p.name as productName, oi.quantity as productQuantity, o.created_at as orderCreatedAt from orders as o join order_items as oi on o.id = oi.order_id join products as p on oi.product_id = p.id", nativeQuery = true)
    List<OrderWithProductDto> findOrdersWithProducts();

    @Query(value = "select o.id as orderId, p.price*oi.quantity as totalPrice, p.name as productName, oi.quantity as productQuantity, o.created_at as orderCreatedAt from orders as o join order_items as oi on o.id = oi.order_id join products as p on oi.product_id = p.id where o.id = :id", nativeQuery = true)
    OrderWithProductDto findOrderWithProductsById(@Param("id")int id);
}
