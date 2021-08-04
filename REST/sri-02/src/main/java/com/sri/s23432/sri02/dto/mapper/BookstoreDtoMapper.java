package com.sri.s23432.sri02.dto.mapper;

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
public class BookstoreDtoMapper {
    private final ModelMapper modelMapper;

    public Bookstore convertToEntity(BookstoreDto dto){
        return modelMapper.map(dto, Bookstore.class);
    }

    public BookstoreDto convertToDto(Bookstore b){
        return modelMapper.map(b, BookstoreDto.class);
    }

    public BookstoreDetailsDto convertToDetailsDto(Bookstore b){
        return modelMapper.map(b, BookstoreDetailsDto.class);
    }
}
