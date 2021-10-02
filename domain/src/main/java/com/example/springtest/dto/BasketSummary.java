package com.example.springtest.dto;

import lombok.Value;

import java.util.List;

@Value
public class BasketSummary {
    List<SummaryItem> items;
}
