package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class ProductDto {

    private Integer productKey;
    private String productName;
    private Integer price;
    private String category;
    private String description;
    private String brand;
    private String color;
    private Integer stock;
    private Timestamp regTime;

}
