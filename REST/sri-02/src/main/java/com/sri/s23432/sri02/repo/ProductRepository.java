package com.sri.s23432.sri02.repo;

import com.sri.s23432.sri02.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
