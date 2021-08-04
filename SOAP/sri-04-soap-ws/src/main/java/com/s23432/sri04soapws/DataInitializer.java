package com.s23432.sri04soapws;

import com.s23432.sri04soapws.model.Book;
import com.s23432.sri04soapws.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(DataInitializer.class);

    private final BookRepository bookRepository;

    public void initData() {
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

        bookRepository.saveAll(Arrays.asList(b1, b2, b3));
        LOG.info("Data initialized");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){initData();}
}
