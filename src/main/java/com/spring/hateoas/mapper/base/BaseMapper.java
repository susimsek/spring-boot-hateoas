package com.spring.hateoas.mapper.base;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface BaseMapper<R,W,T> {
    R tToR(T t);

    R tToRWithLinks(T t);

    T wToT(W w);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void wToT(W w, @MappingTarget T t);
}
