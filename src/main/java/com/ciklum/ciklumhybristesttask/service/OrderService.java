package com.ciklum.ciklumhybristesttask.service;

import java.util.List;

import com.ciklum.ciklumhybristesttask.domain.Order;
import com.ciklum.ciklumhybristesttask.dto.OrderDto;
import com.ciklum.ciklumhybristesttask.dto.OrderWithProductDto;

public interface OrderService {

    OrderDto findById(int id);

    List<OrderWithProductDto> findOrdersWithProduct();

    OrderWithProductDto findOrderWithProductById(int id);

    void delete(int id);

    OrderDto update(Order order);

    void createOrder(String productName, int quantity);
}
