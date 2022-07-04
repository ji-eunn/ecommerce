package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
// company -> brand 컬럼명 변경
// 색상 컬럼
// 사이즈 컬럼 추가 필요
// 상품 이미지 컬럼 추가 필요
// 파일 첨부 테이블 추가 필요
public class ProductDto {

    private Integer productKey;
    private String productName;
    private Integer price;
    private String category;
    private String description;
    private String brand;
    private String color;
    private Integer stock;
    private Date regTime;

}
