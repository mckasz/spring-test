package com.example.springtest;


import com.example.springtest.dto.Product;

interface ProductRepository {
    Product getProduct(String name);
    String save(Product product);
}
