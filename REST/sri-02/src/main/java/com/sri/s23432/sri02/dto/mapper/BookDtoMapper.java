package com.sri.s23432.sri02.dto.mapper;

import com.sri.s23432.sri02.dto.BookDetailsDto;
import com.sri.s23432.sri02.dto.BookDto;
import com.sri.s23432.sri02.dto.BookstoreDetailsDto;
import com.sri.s23432.sri02.dto.BookstoreDto;
import com.sri.s23432.sri02.model.Book;
import com.sri.s23432.sri02.model.Bookstore;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDtoMapper {
    private final ModelMapper modelMapper;

    public BookDto convertToDto(Book b) {
        return modelMapper.map(b, BookDto.class);
    }

    public Book convertToEntity(BookDto dto){
        return modelMapper.map(dto, Book.class);
    }

    public BookDetailsDto convertToDetailsDto(Book b){
        return modelMapper.map(b, BookDetailsDto.class);
    }
}
