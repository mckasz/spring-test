package com.example.springtest;

import com.example.springtest.promotions.Promotion;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor public
class Campaign {
    private final String productName;
    private final Promotion promotion;

    boolean appliesFor(com.example.springtest.SelectedProduct product) {
        return this.productName.equals(product.name());
    }

    List<com.example.springtest.SelectedProduct> applyPromotion(com.example.springtest.SelectedProduct product) {
        return this.promotion.apply(product);
    }

    public static Campaign emptyCampaign() {
        return new Campaign("", Collections::singletonList);
    }
}
