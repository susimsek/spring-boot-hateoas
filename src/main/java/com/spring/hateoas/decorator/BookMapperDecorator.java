package com.spring.hateoas.decorator;


import com.spring.hateoas.domain.Book;
import com.spring.hateoas.mapper.BookMapper;
import com.spring.hateoas.model.request.BookRequestDto;
import com.spring.hateoas.model.response.BookResponseDto;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BookMapperDecorator implements BookMapper  {

    @Setter(onMethod = @__({@Autowired}))
    BookMapper bookMapper;

    @Override
    public BookResponseDto tToR(Book book) {
      return bookMapper.tToR(book);
    }

    @Override
    public Book wToT(BookRequestDto bookRequestDto) {
       return bookMapper.wToT(bookRequestDto);
    }
}
