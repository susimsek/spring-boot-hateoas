package com.spring.hateoas.service.base;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface BaseCrudService<R,W,ID> {

    PagedModel<R> findAll(Pageable page);
    R getById(ID id);
    R save(W w);
    R update(ID id,W w);
    void deleteById(ID id);
}
