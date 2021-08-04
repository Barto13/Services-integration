package com.sri.s23432.sri02;

import com.sri.s23432.sri02.model.Book;
import com.sri.s23432.sri02.model.Bookstore;
import com.sri.s23432.sri02.repo.BookRepository;
import com.sri.s23432.sri02.repo.BookstoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataInitialzer implements ApplicationRunner {
    private final BookstoreRepository bookstoreRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Book b1 = Book.builder()
                .title("The Shining")
                .author("Stephen King")
                .genre("Horror")
                .publicationYear(1977)
                .price(50.00)
                .build();

        Book b2 = Book.builder()
                .title("Metro 2033")
                .author("Dmitry Glukhovsky")
                .genre("Post-apocalyptic")
                .publicationYear(2005)
                .price(60.00)
                .build();

        Book b3 = Book.builder()
                .title("The Call of Cthulhu")
                .author("H. P. Lovecraft")
                .genre("Horror")
                .publicationYear(1928)
                .price(30.00)
                .build();

        Book b4 = Book.builder()
                .title("abcdf")
                .author("aaaaa")
                .genre("Horror")
                .publicationYear(1928)
                .price(30.00)
                .build();

        Bookstore bs1 = Bookstore.builder().name("BookstoreRed").books(new HashSet<>()).build();
        Bookstore bs2 = Bookstore.builder().name("BookstoreGold").books(new HashSet<>()).build();
        Bookstore bs3 = Bookstore.builder().name("BookstoreTest").books(new HashSet<>()).build();

        b1.setBookstore(bs1);
        bs1.getBooks().add(b1);

        b2.setBookstore(bs1);
        bs1.getBooks().add(b2);

        b3.setBookstore(bs2);
        bs2.getBooks().add(b3);

        bookstoreRepository.saveAll(Arrays.asList(bs1, bs2, bs3));
        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
    }

}
