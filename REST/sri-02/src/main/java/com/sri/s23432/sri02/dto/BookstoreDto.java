package com.sri.s23432.sri02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookstoreDto extends RepresentationModel<BookstoreDto> {
    private Long id;
    @NotBlank(message = "name is required")
    @Size(min = 2, max = 255)
    private String name;
}
