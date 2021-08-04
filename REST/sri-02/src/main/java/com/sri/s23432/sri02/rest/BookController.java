package com.sri.s23432.sri02.rest;


import com.sri.s23432.sri02.dto.BookDetailsDto;
import com.sri.s23432.sri02.dto.BookDto;
import com.sri.s23432.sri02.dto.BookstoreDetailsDto;
import com.sri.s23432.sri02.dto.BookstoreDto;
import com.sri.s23432.sri02.dto.mapper.BookDtoMapper;
import com.sri.s23432.sri02.dto.mapper.BookstoreDtoMapper;
import com.sri.s23432.sri02.model.Book;
import com.sri.s23432.sri02.model.Bookstore;
import com.sri.s23432.sri02.repo.BookRepository;
import com.sri.s23432.sri02.repo.BookstoreRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository booksRepository;
    private final ModelMapper modelMapper;
    private final BookDtoMapper bookDtoMapper;
    private final BookstoreRepository bookstoreRepository;
    private final BookstoreDtoMapper bookstoreDtoMapper;

//    public BookController(BookRepository booksRepository, ModelMapper modelMapper){
//        this.booksRepository = booksRepository;
//        this.modelMapper = modelMapper;
//    }

    private BookDto convertToDto(Book p) {
        return modelMapper.map(p, BookDto.class);
    }

    private Book convertToEntity(BookDto dto){
        return modelMapper.map(dto, Book.class);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<BookDto>> getBooks(){
        List<Book> allBooks = booksRepository.findAll();
        List<BookDto> result = allBooks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        for(BookDto dto : result){
            dto.add(createSelfLink(dto.getId()));
            dto.add(createBooksLink(dto.getId()));
        }
        Link linkCollectionSelf = linkTo(methodOn(BookController.class).getBooks()).withSelfRel();
        CollectionModel<BookDto> resultWithLink = CollectionModel.of(result, linkCollectionSelf);
        return new ResponseEntity<>(resultWithLink, HttpStatus.OK);
    }

//    @GetMapping("/{bookId}")
//    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId){
//        Optional<Book> book = booksRepository.findById(bookId);
//        if(book.isPresent()){
//            BookDto booksDto = convertToDto(book.get());
//            return new ResponseEntity<>(booksDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDetailsDto> getBookById(@PathVariable("bookId") Long bookId){
        Optional<Book> byId = booksRepository.findById(bookId);
        if(byId.isPresent()) {
            BookDetailsDto detailsDto = bookDtoMapper.convertToDetailsDto(byId.get());
            detailsDto.add(createSelfLink(bookId));

//            BookDto dto = bookDtoMapper.convertToDto(byId.get());
//            dto.add(createSelfLink(bookId));
//            return new ResponseEntity<>(dto, HttpStatus.OK);

            return new ResponseEntity<>(detailsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{bookId}/bookstores")
    public ResponseEntity getBookstoresByBookId(@PathVariable("bookId") Long bookId) {
        Bookstore allBookstores = bookstoreRepository.findBookstoresByBookId(bookId);
        BookstoreDto result = bookstoreDtoMapper.convertToDto(allBookstores);
//        List<BookstoreDto> result = allBookstores.stream()
//                .map(bookstoreDtoMapper::convertToDto)
//                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBook(@Valid @RequestBody BookDto book){
        Book entity = convertToEntity(book);
        booksRepository.save(entity);

        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        headers.add("Location", location.toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity updateBook(@PathVariable Long bookId, @RequestBody BookDto booksDto) {
        Optional<Book> currentBook = booksRepository.findById(bookId);
        if(currentBook.isPresent()) {
            booksDto.setId(bookId);
            Book entity = convertToEntity(booksDto);
            booksRepository.save(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{bookId}/{bookstoreId}")
    public ResponseEntity addBookstoreToBook(@PathVariable Long bookId, @PathVariable Long bookstoreId, @RequestBody BookDto booksDto) {
        Optional<Book> currentBook = booksRepository.findById(bookId);
        Optional<Bookstore> currentBookstore = bookstoreRepository.findById(bookstoreId);
        if(currentBook.isPresent()) {
//            booksDto.setId(bookId);
//            Book entity = convertToEntity(booksDto);
            Book entity = currentBook.get();
            Bookstore bs1 = currentBookstore.get();

            entity.setBookstore(bs1);
            bs1.getBooks().add(entity);

            bookstoreRepository.save(bs1);
            booksRepository.save(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity deleteBook(@PathVariable Long bookId){
        booksRepository.deleteById(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Link createSelfLink(Long bookId) {
        return linkTo(methodOn(BookController.class).getBookById(bookId)).withSelfRel();
    }

    private Link createBooksLink(Long bookId) {
        return linkTo(methodOn(BookController.class).getBookstoresByBookId(bookId)).withRel("bookstores");
    }
}
