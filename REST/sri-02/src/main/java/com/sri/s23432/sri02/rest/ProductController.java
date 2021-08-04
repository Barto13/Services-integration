package com.sri.s23432.sri02.rest;


import com.sri.s23432.sri02.dto.ProductDto;
import com.sri.s23432.sri02.model.Product;
import com.sri.s23432.sri02.repo.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductController(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    private ProductDto convertToDto(Product p) {
        return modelMapper.map(p, ProductDto.class);
    }

    private Product convertToEntity(ProductDto dto){
        return modelMapper.map(dto, Product.class);
    }

    @GetMapping
    public ResponseEntity<Collection<ProductDto>> getProducts(){
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> result = allProducts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long prodId){
        Optional<Product> prod = productRepository.findById(prodId);
        if(prod.isPresent()){
            ProductDto productDto = convertToDto(prod.get());
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity saveNewProduct(@RequestBody ProductDto prod){
        Product entity = convertToEntity(prod);
        productRepository.save(entity);

        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        headers.add("Location", location.toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{prodId}")
    public ResponseEntity updateProduct(@PathVariable Long prodId, @RequestBody ProductDto productDto) {
        Optional<Product> currentProd = productRepository.findById(prodId);
        if(currentProd.isPresent()) {
            productDto.setId(prodId);
            Product entity = convertToEntity(productDto);
            productRepository.save(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity deleteProduct(@PathVariable Long prodId){
        productRepository.deleteById(prodId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
