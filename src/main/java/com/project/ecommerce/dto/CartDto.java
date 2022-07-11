package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CartDto {

    private Integer cartKey;
    private String productKey;
    private Integer quantity;
    private Integer price;
    private Integer memberKey;
    private Integer delFlag;
    private Date createTime;

}
