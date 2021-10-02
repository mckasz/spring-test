package com.example.springtest.promotions;

import com.example.springtest.SelectedProduct;

import java.util.List;

public interface Promotion {
    List<SelectedProduct> apply(SelectedProduct product);
}
