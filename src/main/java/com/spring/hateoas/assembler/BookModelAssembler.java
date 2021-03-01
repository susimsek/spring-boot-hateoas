package com.spring.hateoas.assembler;

import com.spring.hateoas.controller.rest.BookController;
import com.spring.hateoas.domain.Book;
import com.spring.hateoas.mapper.BookMapper;
import com.spring.hateoas.model.response.BookResponseDto;
import com.spring.hateoas.util.BookLinkUtils;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, BookResponseDto> {

    @Setter(onMethod = @__({@Autowired}))
    BookMapper bookMapper;

    @Setter(onMethod = @__({@Autowired}))
    BookLinkUtils bookLinkUtils;

    public BookModelAssembler() {
        super(BookController.class, BookResponseDto.class);
    }

    @Override
    public BookResponseDto toModel(Book book) {
        BookResponseDto bookResponseDto = bookMapper.tToR(book);
        return bookLinkUtils.getLinks(bookResponseDto);
    }

    @Override
    public CollectionModel<BookResponseDto> toCollectionModel(Iterable<? extends Book> entities) {
        CollectionModel<BookResponseDto> collectionModel = super.toCollectionModel(entities);

        collectionModel.add(bookLinkUtils.getLinksForCollection());

        return collectionModel;
    }




}
