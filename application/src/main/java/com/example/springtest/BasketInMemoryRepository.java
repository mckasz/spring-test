package com.example.springtest;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
class BasketInMemoryRepository implements BasketRepository  {
    private final Map<Long, Basket> map = new HashMap<>();

    @Override
    public Basket getBasket(Long basketId) {
        return map.getOrDefault(basketId, new Basket((long) map.size(), Collections.emptyList(), Campaign.emptyCampaign()));
    }

    @Override
    public Long save(Basket basket) {
        map.put(basket.id(), basket);
        return basket.id();
    }
}
