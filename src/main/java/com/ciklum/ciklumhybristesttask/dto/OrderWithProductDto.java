package com.ciklum.ciklumhybristesttask.dto;

import java.time.LocalDateTime;

public interface OrderWithProductDto{

	Integer getOrderId();
	Integer getTotalPrice();
	String getProductName();
	Integer getProductQuantity();
	LocalDateTime getOrderCreatedAt();
}
