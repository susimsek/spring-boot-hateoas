package com.spring.hateoas.mapper;


import com.spring.hateoas.decorator.BookMapperDecorator;
import com.spring.hateoas.domain.Book;
import com.spring.hateoas.mapper.base.BaseMapper;
import com.spring.hateoas.model.request.BookRequestDto;
import com.spring.hateoas.model.response.BookResponseDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@DecoratedWith(BookMapperDecorator.class)
@Mapper
public interface BookMapper extends BaseMapper<BookResponseDto, BookRequestDto, Book> {
}
