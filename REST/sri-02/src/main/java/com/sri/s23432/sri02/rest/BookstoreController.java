package com.sri.s23432.sri02.rest;

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
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookstores")
@RequiredArgsConstructor
public class BookstoreController {

    private final BookstoreRepository bookstoreRepository;
    private final BookRepository booksRepository;
    private final BookstoreDtoMapper bookstoreDtoMapper;
    private final BookDtoMapper bookDtoMapper;
    private final ModelMapper modelMapper;

    private BookstoreDto convertToDto(Bookstore p) {
        return modelMapper.map(p, BookstoreDto.class);
    }

    private Bookstore convertToEntity(BookstoreDto dto){
        return modelMapper.map(dto, Bookstore.class);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<BookstoreDto>> getBookstores(){
        List<Bookstore> allBookstores = bookstoreRepository.findAll();
        List<BookstoreDto> result = allBookstores.stream()
                .map(bookstoreDtoMapper::convertToDto)
                .collect(Collectors.toList());
        for(BookstoreDto dto : result){
            dto.add(createSelfLink(dto.getId()));
            dto.add(createBooksLink(dto.getId()));
        }
        Link linkCollectionSelf = linkTo(methodOn(BookstoreController.class).getBookstores()).withSelfRel();
        CollectionModel<BookstoreDto> resultWithLink = CollectionModel.of(result, linkCollectionSelf);
        return new ResponseEntity<>(resultWithLink, HttpStatus.OK);
    }

    @GetMapping("/{bookstoreId}")
    public ResponseEntity<BookstoreDetailsDto> getBookstoreById(@PathVariable("bookstoreId") Long bookstoreId){
        Optional<Bookstore> byId = bookstoreRepository.findById(bookstoreId);
        if(byId.isPresent()) {
            BookstoreDetailsDto detailsDto = bookstoreDtoMapper.convertToDetailsDto(byId.get());
            detailsDto.add(createSelfLink(bookstoreId));
            return new ResponseEntity<>(detailsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{bookstoreId}/books")
    public ResponseEntity getBooksByBookstoreId(@PathVariable("bookstoreId") Long bookstoreId) {
        List<Book> allBooks = booksRepository.findBooksByBookstoreId(bookstoreId);
        List<BookDto> result = allBooks.stream()
                .map(bookDtoMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBookstore(@Valid @RequestBody BookstoreDto bookstore){
        Bookstore entity = convertToEntity(bookstore);
        bookstoreRepository.save(entity);

        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        headers.add("Location", location.toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{bookstoreId}")
    public ResponseEntity updateBookstore(@PathVariable Long bookstoreId, @RequestBody BookstoreDto bookstoreDto) {
        Optional<Bookstore> currentBookstore = bookstoreRepository.findById(bookstoreId);
        if(currentBookstore.isPresent()) {
            bookstoreDto.setId(bookstoreId);
            Bookstore entity = bookstoreDtoMapper.convertToEntity(bookstoreDto);
            bookstoreRepository.save(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{bookstoreId}/{bookId}")
    public ResponseEntity addBookToBookstore(@PathVariable Long bookstoreId, @PathVariable Long bookId, @RequestBody BookstoreDto bookstoreDto) {
        Optional<Bookstore> currentBookstore = bookstoreRepository.findById(bookstoreId);
        Optional<Book> currentBook = booksRepository.findById(bookId);

        if(currentBookstore.isPresent()) {
//            bookstoreDto.setId(bookstoreId);
//            Bookstore entity = bookstoreDtoMapper.convertToEntity(bookstoreDto);
            Bookstore entity = currentBookstore.get();

            Book book = currentBook.get();

            book.setBookstore(entity);
            entity.getBooks().add(book);

            bookstoreRepository.save(entity);
            booksRepository.save(book);

            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{bookstoreId}")
    public ResponseEntity deleteBookstore(@PathVariable Long bookstoreId){
        bookstoreRepository.deleteById(bookstoreId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Link createSelfLink(Long bookstoreId) {
        return linkTo(methodOn(BookstoreController.class).getBookstoreById(bookstoreId)).withSelfRel();
    }

    private Link createBooksLink(Long bookstoreId) {
        return linkTo(methodOn(BookstoreController.class).getBooksByBookstoreId(bookstoreId)).withRel("books");
    }

//    public ResponseEntity addExistingBookToBookstore()
}
