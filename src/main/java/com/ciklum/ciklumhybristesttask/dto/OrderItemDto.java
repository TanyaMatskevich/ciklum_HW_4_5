package com.ciklum.ciklumhybristesttask.dto;

import javax.validation.constraints.NotEmpty;


public class OrderItemDto extends BaseDto{

	@NotEmpty(message = "{order.not.empty}")
	private OrderDto order;
	@NotEmpty(message = "{product.not.empty}")
	private ProductDto product;
	@NotEmpty(message = "{quantity.not.empty}")
	private Integer quantity;

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(final OrderDto order) {
		this.order = order;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(final ProductDto product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}
}
