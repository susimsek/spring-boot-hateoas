package com.spring.hateoas.service.impl;

import com.spring.hateoas.domain.Book;
import com.spring.hateoas.mapper.BookMapper;
import com.spring.hateoas.model.request.BookRequestDto;
import com.spring.hateoas.model.response.BookResponseDto;
import com.spring.hateoas.repository.BookRepository;
import com.spring.hateoas.service.BookService;
import com.spring.hateoas.service.base.AbstractBaseCrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class BookServiceImpl extends AbstractBaseCrudService<BookResponseDto, BookRequestDto,Book,String> implements BookService {

    BookRepository bookRepository;
    BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepository) {
        super(bookRepository,bookMapper);
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }
}

