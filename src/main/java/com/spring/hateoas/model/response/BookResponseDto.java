package com.spring.hateoas.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Relation(collectionRelation = "books")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseDto extends RepresentationModel<BookResponseDto> {

    String id;
    String title;
    String author;
    String releaseDate;
}
