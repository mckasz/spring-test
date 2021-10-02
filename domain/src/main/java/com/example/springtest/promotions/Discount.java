package com.example.springtest.promotions;

import static java.lang.String.format;

public class Discount {
    private final double discount;

    Discount(int discount) {
        if (discount > 100) {
            throw new IllegalArgumentException(format("Discount cannot be higher than 100. Given: %d", discount));
        }

        this.discount = discount;
    }

    public double multiplier() {
        return 1 - (discount / 100);
    }
}
