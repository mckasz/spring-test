package com.example.springtest.promotions;

import com.example.springtest.SelectedProduct;
import com.example.springtest.SelectedProducts;

import java.util.List;

public class Promotion3for2 implements Promotion {

    @Override
    public List<SelectedProduct> apply(SelectedProduct product) {
        SelectedProducts productsAfterPromotion = new SelectedProducts();
        productsAfterPromotion.add(product.samePrice(numberOfSamePriceProducts(product.quantity())));
        productsAfterPromotion.add(product.freeProduct(numberOfFreeProducts(product.quantity())));
        return productsAfterPromotion.asList();
    }

    private int numberOfSamePriceProducts(int quantity) {
        int numberOfFreeProducts = numberOfFreeProducts(quantity);
        return quantity - numberOfFreeProducts;
    }

    private int numberOfFreeProducts(int quantity) {
        return quantity / 3;
    }
}
