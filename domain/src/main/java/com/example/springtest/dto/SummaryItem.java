package com.example.springtest.dto;

import lombok.Value;

@Value
public class SummaryItem {
    private final String name;
    private final int price;
    private final int quantity;
}
