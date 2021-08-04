package com.s23432.sri04soapws.endpoint;

import com.s23432.sri04soapws.config.SoapWSConfig;
import com.s23432.sri04soapws.model.Book;
import com.s23432.sri04soapws.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import s23432.sri04soapws.books.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Endpoint
@RequiredArgsConstructor
public class BookEndpoint {

    private final BookRepository bookRepository;

    @PayloadRoot(namespace = SoapWSConfig.BOOK_NAMESPACE, localPart = "getBooksRequest")
    @ResponsePayload
    public GetBooksResponse getBooks(@RequestPayload GetBooksRequest req){
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> dtoList = bookList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        GetBooksResponse res = new GetBooksResponse();
        res.getBooks().addAll(dtoList);
        return res;
    }

    @PayloadRoot(namespace = SoapWSConfig.BOOK_NAMESPACE, localPart = "getBookByIdRequest")
    @ResponsePayload
    public GetBookByIdResponse getBookByIdResponse(@RequestPayload GetBookByIdRequest req){
        Long bookId = req.getBookId().longValue();
        Optional<Book> book = bookRepository.findById(bookId);
        GetBookByIdResponse res = new GetBookByIdResponse();
        res.setBook(convertToDto(book.orElse(null)));
        return res;
    }

    @PayloadRoot(namespace = SoapWSConfig.BOOK_NAMESPACE, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest req){
        BookDto bookDto = req.getBook();
        Book book = convertToEntity(bookDto);
        bookRepository.save(book);
        AddBookResponse response = new AddBookResponse();
        response.setBookId(new BigDecimal(book.getId()));
        return response;
    }

    @PayloadRoot(namespace = SoapWSConfig.BOOK_NAMESPACE, localPart = "getBooksPriceSumRequest")
    @ResponsePayload
    public GetBooksPriceSumResponse getBooksPriceSum(@RequestPayload GetBooksPriceSumRequest req){
        double bookPriceSum = bookRepository.sumPriceAmount();
        GetBooksPriceSumResponse res = new GetBooksPriceSumResponse();
        res.setBooksPriceSum(bookPriceSum);
        res.getBooksPriceSum();
        return res;
    }

    @PayloadRoot(namespace = SoapWSConfig.BOOK_NAMESPACE, localPart = "getBooksByGenreRequest")
    @ResponsePayload
    public GetBooksByGenreResponse getBooksByGenre(@RequestPayload GetBooksByGenreRequest req){
        String bookGenre = req.getBookGenre();
        List<Book> bookList = bookRepository.findBooksByGenre(bookGenre);
        List<BookDto> dtoList = bookList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        GetBooksByGenreResponse res = new GetBooksByGenreResponse();
        res.getBooks().addAll(dtoList);
        return res;
    }

    @PayloadRoot(namespace = SoapWSConfig.BOOK_NAMESPACE, localPart = "getCheapestBooksRequest")
    @ResponsePayload
    public GetCheapestBooksResponse getCheapestBooksResponse(@RequestPayload GetCheapestBooksRequest req){
        List<Book> bookList = bookRepository.findCheapestBooks();
        List<BookDto> dtoList = bookList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        GetCheapestBooksResponse res = new GetCheapestBooksResponse();
        res.getBooks().addAll(dtoList);
        return res;
    }

    private BookDto convertToDto(Book b){
        if(b == null){
            return null;
        }
        BookDto dto = new BookDto();
        dto.setId(new BigDecimal(b.getId()));
        dto.setTitle(b.getTitle());
        dto.setAuthor(b.getAuthor());
        dto.setGenre(b.getGenre());
        dto.setPublicationYear(b.getPublicationYear());
        dto.setPrice(b.getPrice());

        return dto;
    }

    private Book convertToEntity(BookDto dto){
        return Book.builder()
                .id(dto.getId() != null ? dto.getId().longValue() : null)
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .genre(dto.getGenre())
                .publicationYear(dto.getPublicationYear())
                .price(dto.getPrice())
                .build();
    }

}
