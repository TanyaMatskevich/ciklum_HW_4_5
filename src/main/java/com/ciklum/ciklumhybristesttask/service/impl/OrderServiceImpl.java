package com.ciklum.ciklumhybristesttask.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.ciklum.ciklumhybristesttask.domain.Order;

import com.ciklum.ciklumhybristesttask.domain.OrderItem;
import com.ciklum.ciklumhybristesttask.dto.OrderDto;
import com.ciklum.ciklumhybristesttask.dto.OrderWithProductDto;
import com.ciklum.ciklumhybristesttask.dto.ProductDto;
import com.ciklum.ciklumhybristesttask.repo.OrderItemRepository;
import com.ciklum.ciklumhybristesttask.repo.OrderRepository;
import com.ciklum.ciklumhybristesttask.service.OrderService;
import com.ciklum.ciklumhybristesttask.service.ProductService;
import com.ciklum.ciklumhybristesttask.service.mapper.OrderItemMapper;
import com.ciklum.ciklumhybristesttask.service.mapper.OrderMapper;
import com.ciklum.ciklumhybristesttask.service.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;
	private final OrderItemRepository orderItemRepository;
	private final ProductService productService;
	private final ProductMapper productMapper;
	private final OrderItemMapper orderItemsMapper;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, OrderItemRepository orderItemRepository,
			ProductService productService, ProductMapper productMapper, OrderItemMapper orderItemsMapper) {
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
		this.orderItemRepository = orderItemRepository;
		this.productService = productService;
		this.productMapper = productMapper;
		this.orderItemsMapper = orderItemsMapper;
	}

	@Override
	public OrderDto findById(int id) {
		return orderMapper.entityToDto(orderRepository.findById(id).orElseThrow(EntityNotFoundException::new));
	}

	@Override
	public List<OrderWithProductDto> findOrdersWithProduct() {
		return orderRepository.findOrdersWithProducts();
	}

	@Override
	public OrderWithProductDto findOrderWithProductById(int id) {
		return orderRepository.findOrderWithProductsById(id);
	}

	@Override
	public void delete(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public OrderDto update(Order order) {
		return orderMapper.entityToDto(orderRepository.save(order));
	}

	@Override
	public void createOrder(final String productName, final int quantity) {
		ProductDto productDto = productService.findByName(productName);
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(createOrderInternally());
		orderItem.setProduct(productMapper.dtoToEntity(productDto));
		orderItem.setQuantity(quantity);
		orderItemsMapper.entityToDto(orderItemRepository.save(orderItem));
	}

	private Order createOrderInternally() {
		int userId = (int) (Math.random() * 999);
		String status = "created";
		LocalDateTime createdAt = LocalDateTime.now();
		return orderRepository.save(new Order(userId, status, createdAt));
	}
}
