package ru.vsu.cs.kapuchinka.webtech3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "w_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @NotNull
    @Column(name = "name_product")
    private String nameProduct;

    @NotNull
    @Column(name = "type_product")
    private String typeProduct;
}
