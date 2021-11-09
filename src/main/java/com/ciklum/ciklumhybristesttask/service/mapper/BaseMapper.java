package com.ciklum.ciklumhybristesttask.service.mapper;

import java.util.List;

import com.ciklum.ciklumhybristesttask.domain.DomainObject;
import com.ciklum.ciklumhybristesttask.dto.BaseDto;

public interface BaseMapper<D extends BaseDto, E extends DomainObject> {

	D entityToDto(E e);

	E dtoToEntity(D d);

	List<D> entitiesToDtoList(List<E> eList);
}
