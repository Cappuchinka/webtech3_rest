package ru.vsu.cs.kapuchinka.webtech3.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {
    private Integer productId;
    private Integer placeId;
    private LocalDate timestamp = LocalDate.now();
}
