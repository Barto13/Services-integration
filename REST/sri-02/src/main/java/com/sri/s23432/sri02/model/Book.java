package com.sri.s23432.sri02.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String genre;
    private String author;
    private Integer publicationYear;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "bookstore_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Bookstore bookstore;

}
