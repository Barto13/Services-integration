package com.sri.s23432.sri02.repo;

import com.sri.s23432.sri02.model.Book;
import com.sri.s23432.sri02.model.Bookstore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    @Query("select b.books from Bookstore as b where b.id=:bookstoreId")
    List<Book> findBooksByBookstoreId(@Param("bookstoreId") Long bookstoreId);

    @Query("from Book b join fetch b.bookstore where b.id = :bookId")
    Optional<Book> findById(@Param("bookId") Long bookId);



}
