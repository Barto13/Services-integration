package com.sri.s23432.sri02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookstoreDetailsDto extends RepresentationModel<BookstoreDetailsDto> {
    private Long id;
    private String name;
    private List<BookDto> books;
}
