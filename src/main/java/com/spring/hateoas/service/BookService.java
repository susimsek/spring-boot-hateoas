package com.spring.hateoas.service;

import com.spring.hateoas.model.request.BookRequestDto;
import com.spring.hateoas.model.response.BookResponseDto;
import com.spring.hateoas.service.base.BaseCrudService;

public interface BookService extends BaseCrudService<BookResponseDto, BookRequestDto,String> {
}
