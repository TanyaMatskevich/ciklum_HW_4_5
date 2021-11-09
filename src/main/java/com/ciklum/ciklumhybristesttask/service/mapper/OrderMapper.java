package com.ciklum.ciklumhybristesttask.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ciklum.ciklumhybristesttask.domain.Order;
import com.ciklum.ciklumhybristesttask.dto.OrderDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends BaseMapper<OrderDto, Order>{

}
