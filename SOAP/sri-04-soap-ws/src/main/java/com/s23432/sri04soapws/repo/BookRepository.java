package com.s23432.sri04soapws.repo;

import com.s23432.sri04soapws.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    @Query("SELECT sum(b.price) from Book b")
    double sumPriceAmount();

    @Query("SELECT b FROM Book b WHERE b.genre = ?1")
    List<Book> findBooksByGenre(String genre);

    @Query("SELECT b, b.price FROM Book b WHERE b.price=(SELECT MIN(b.price) FROM b)")
    List<Book> findCheapestBooks();

}
