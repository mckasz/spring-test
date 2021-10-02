package com.example.springtest.dto;

import com.example.springtest.SelectedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private int price;
    private SelectedProduct.Type type;

    public SelectedProduct buildSelectedProduct(int quantity) {
        return new SelectedProduct(name, price, quantity, type);
    }
}
