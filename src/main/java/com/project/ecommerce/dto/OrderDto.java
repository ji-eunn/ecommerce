package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class OrderDto {

    private Integer orderKey;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private Integer memberKey;
    private String requirement;
    private Integer totalPrice;
    private Timestamp orderTime;

}
