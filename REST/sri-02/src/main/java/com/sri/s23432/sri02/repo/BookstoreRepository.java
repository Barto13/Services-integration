package com.sri.s23432.sri02.repo;

import com.sri.s23432.sri02.model.Book;
import com.sri.s23432.sri02.model.Bookstore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookstoreRepository extends CrudRepository<Bookstore, Long> {
    List<Bookstore> findAll();

    @Query("from Bookstore b join fetch b.books where b.id = :bookstoreId")
    Optional<Bookstore> findById(@Param("bookstoreId") Long bookstoreId);

    @Query("select b.bookstore from Book as b where b.id=:bookId")
    Bookstore findBookstoresByBookId(@Param("bookId") Long bookId);
}
