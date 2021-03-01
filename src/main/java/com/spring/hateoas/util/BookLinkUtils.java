package com.spring.hateoas.util;

import com.spring.hateoas.controller.rest.BookController;
import com.spring.hateoas.model.response.BookResponseDto;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



@Component
public class BookLinkUtils implements LinkUtils<BookResponseDto> {

    @Override
    public BookResponseDto getLinks(BookResponseDto bookResponseDto) {
        Link[] links = new Link[]{
                linkTo(methodOn(BookController.class).listBooks(null))
                        .withRel("books")
                        .withType("GET")
                        .withDeprecation("List Books"),
                linkTo(methodOn(BookController.class).createBook(null))
                        .withRel("books")
                        .withType("POST")
                        .withDeprecation("Create Book"),
                linkTo(methodOn(BookController.class).updateBook(bookResponseDto.getId(),null))
                        .withRel("books")
                        .withType("PUT")
                        .withDeprecation("Update Book"),
                linkTo(methodOn(BookController.class).getBook(bookResponseDto.getId()))
                        .withRel("books")
                        .withType("GET")
                        .withDeprecation("Get Book"),
                linkTo(methodOn(BookController.class).getBook(bookResponseDto.getId()))
                        .withRel("books")
                        .withType("DELETE")
                        .withDeprecation("Delete Book")
        };

        bookResponseDto.add(links);

        return bookResponseDto;
    }

    @Override
    public Link[] getLinksForCollection() {
        Link[] links = new Link[]{
                linkTo(methodOn(BookController.class).listBooks(null))
                        .withRel("books")
                        .withType("GET")
                        .withDeprecation("List Books"),
                linkTo(methodOn(BookController.class).createBook(null))
                        .withRel("books")
                        .withType("POST")
                        .withDeprecation("Create Book")
        };

        return links;
    }
}
