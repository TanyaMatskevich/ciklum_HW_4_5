package com.ciklum.ciklumhybristesttask.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ciklum.ciklumhybristesttask.domain.OrderItem;
import com.ciklum.ciklumhybristesttask.dto.OrderItemDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper extends BaseMapper<OrderItemDto, OrderItem> {

}
