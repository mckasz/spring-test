package com.example.springtest;

interface BasketRepository {
    com.example.springtest.Basket getBasket(Long basketId);
    Long save(com.example.springtest.Basket basket);
}
