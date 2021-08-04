package com.sri.s23432.sri02.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bookstore")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();
}
