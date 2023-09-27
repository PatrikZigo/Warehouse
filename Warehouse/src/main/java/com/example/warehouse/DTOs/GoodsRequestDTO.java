package com.example.warehouse.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GoodsRequestDTO {
    private String name;
    private int amount;
}
