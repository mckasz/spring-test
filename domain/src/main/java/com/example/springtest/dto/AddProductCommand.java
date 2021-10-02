package com.example.springtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductCommand {
    private Long basketId;
    private String name;
    private int quantity;
}
