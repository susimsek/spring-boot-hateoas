package com.spring.hateoas.decorator;


import com.spring.hateoas.domain.Book;
import com.spring.hateoas.factory.BookLinkFactory;
import com.spring.hateoas.mapper.BookMapper;
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

    @Setter(onMethod = @__({@Autowired}))
    BookLinkFactory bookLinkFactory;

    @Override
    public BookResponseDto tToRWithLinks(Book book) {
        BookResponseDto bookResponseDto = bookMapper.tToR(book);
        return bookLinkFactory.getLinks(bookResponseDto);
    }
}
