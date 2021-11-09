package com.ciklum.ciklumhybristesttask.util.constant;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.ciklum.ciklumhybristesttask.dto.OrderWithProductDto;

@Component
public class OrderIdComparator implements Comparator<OrderWithProductDto> {

	@Override
	public int compare(OrderWithProductDto a, OrderWithProductDto b) {
		return Integer.compare(a.getOrderId(), b.getOrderId());
	}
}
