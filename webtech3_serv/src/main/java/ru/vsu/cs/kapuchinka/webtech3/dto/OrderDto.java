package ru.vsu.cs.kapuchinka.webtech3.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Integer productId;
    private Integer placeId;
    private LocalDateTime timestamp = LocalDateTime.now();
}
