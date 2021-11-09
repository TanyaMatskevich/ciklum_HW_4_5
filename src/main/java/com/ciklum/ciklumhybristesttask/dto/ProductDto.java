package com.ciklum.ciklumhybristesttask.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ciklum.ciklumhybristesttask.enums.ProductStatus;

public class ProductDto extends BaseDto{

	@NotEmpty(message = "{name.not.empty}")
	private String name;
	@NotNull(message = "{product.price.not.null}")
	private Integer price;
	@NotNull(message = "{product.status.not.empty}")
	private ProductStatus productStatus;
	private LocalDateTime created_at;

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
		return LocalDateTime.now();
	}

	public void setCreated_at(final LocalDateTime created_at) {
		this.created_at = created_at;
	}


	public ProductDto(final String name, final Integer price, final ProductStatus productStatus, final LocalDateTime created_at) {
		this.name = name;
		this.price = price;
		this.productStatus = productStatus;
		this.created_at = created_at;
	}
}
