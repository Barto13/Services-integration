package com.sri.s23432.sri02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsDto extends RepresentationModel<BookDetailsDto> {
    private Long id;
    private String title;
    private String genre;
    private String author;
    private Integer publicationYear;
    private Float price;
    private Long bookstore_id;
}
