package com.example.springtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectedProducts implements Iterable<com.example.springtest.SelectedProduct> {
    private final Map<com.example.springtest.SelectedProduct.Key, com.example.springtest.SelectedProduct> map = new HashMap<>();

    public void add(com.example.springtest.SelectedProduct product) {
        com.example.springtest.SelectedProduct.Key key = product.key();
        if (product.quantity() != 0) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key).addQuantity(product));
            } else {
                map.put(key, product);
            }
        }
    }

    public List<com.example.springtest.SelectedProduct> asList() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Iterator<com.example.springtest.SelectedProduct> iterator() {
        return map.values().iterator();
    }
}