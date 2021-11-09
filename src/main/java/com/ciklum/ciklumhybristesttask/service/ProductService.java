package com.ciklum.ciklumhybristesttask.service;

import java.util.List;

import javax.validation.Valid;

import com.ciklum.ciklumhybristesttask.dto.OrderedProductDto;
import com.ciklum.ciklumhybristesttask.dto.ProductDto;

public interface ProductService {

	ProductDto findByName(String name);

	ProductDto findById(int id);

	void delete(int id);

	void deleteAll();

	ProductDto save(@Valid ProductDto productDto);

	List<ProductDto> findAll();

	boolean checkPassword(String inputPassword);

	List<OrderedProductDto> findOrderedProducts();
}
