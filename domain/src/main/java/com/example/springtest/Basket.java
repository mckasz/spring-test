package com.example.springtest;

import java.util.ArrayList;
import java.util.List;

class Basket {
    private final Long id;
    private final com.example.springtest.SelectedProducts products = new com.example.springtest.SelectedProducts();
    private final Campaign campaign;

    public Basket(Long id, List<com.example.springtest.SelectedProduct> products, Campaign campaign) {
        this.id = id;
        this.campaign = campaign;
        for (com.example.springtest.SelectedProduct product : products) {
            this.products.add(product);
        }
    }

    public Long id() {
        return id;
    }

    void add(com.example.springtest.SelectedProduct product) {
        products.add(product);
    }

    List<com.example.springtest.SelectedProduct> products() {
        List<com.example.springtest.SelectedProduct> productsAfterPromotion = new ArrayList<>();
        for (com.example.springtest.SelectedProduct product : products) {
            if (campaign.appliesFor(product)) {
                productsAfterPromotion.addAll(campaign.applyPromotion(product));
            } else {
                productsAfterPromotion.add(product);
            }
        }
        return productsAfterPromotion;
    }
}
