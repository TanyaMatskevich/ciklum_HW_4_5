package com.ciklum.ciklumhybristesttask.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ciklum.ciklumhybristesttask.domain.OrderItem;

public class OrderDto extends BaseDto {

	private int user_id;
	private String status;
	private LocalDateTime created_at;
	private List<OrderItem> orderItems;

	public OrderDto(final int user_id, final String status, final LocalDateTime created_at) {
		this.user_id = user_id;
		this.status = status;
		this.created_at = created_at;
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
