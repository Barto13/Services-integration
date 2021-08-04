package com.sri.s23432.sri02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto extends RepresentationModel<BookDto> {
    private Long id;
    @NotBlank(message = "title is required")
    @Size(min = 2, max = 255)
    private String title;
    @NotBlank(message = "genre is required")
    @Size(min = 2, max = 255)
    private String genre;
    @NotBlank(message = "author is required")
    @Size(min = 2, max = 255)
    private String author;
    @NotNull(message = "publication year is required")
    private Integer publicationYear;
    @NotNull(message = "price is required")
    private Float price;
}
