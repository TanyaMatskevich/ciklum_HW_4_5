package com.ciklum.ciklumhybristesttask.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ciklum.ciklumhybristesttask.domain.Product;
import com.ciklum.ciklumhybristesttask.dto.ProductDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends BaseMapper<ProductDto, Product>{

}
