package com.spring.hateoas.controller.rest;


import com.spring.hateoas.model.request.BookRequestDto;
import com.spring.hateoas.model.response.BookResponseDto;
import com.spring.hateoas.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Tag(name = "books", description = "Retrieve and manage books")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping(value = "/versions/1",
        consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, "application/x-yaml"},
        produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, "application/x-yaml"})
public class BookController {

    final BookService bookService;

    @PageableAsQueryParam
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Get all Books")
    @GetMapping(value = "/books" )
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<EntityModel<BookResponseDto>> listBooks(Pageable page) {
        return bookService.findAll(page);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created",content = @Content(schema = @Schema(implementation = BookResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Create new Book")
    @PostMapping(value = "/books" )
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        return bookService.save(bookRequestDto);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok",content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Update existing Book")
    @PutMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponseDto updateBook(@PathVariable String bookId, @Valid @RequestBody BookRequestDto bookRequestDto) {
        return bookService.update(bookId,bookRequestDto);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Get existing Book")
    @GetMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponseDto getBook(@PathVariable String bookId) {
        return bookService.getById(bookId);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Delete existing Book")
    @DeleteMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String bookId) {
        bookService.deleteById(bookId);
    }
}
