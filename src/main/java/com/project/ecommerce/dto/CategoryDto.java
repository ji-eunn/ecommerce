package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
Dto 작성 시에는 테이블의 컬럼 다 넣지 않고 사용할 컬럼만 변수로 만들면 된다.
하지만 JPA 에서는 엔티티라는 것을 만들기 때문에 테이블과 일치해줘야 한다.
*/
public class CategoryDto {

    private Integer categoryKey;   // 카테고리 구분키
    private String categoryName;   // 카테고리명
    private Integer categoryOrder; // 카테고리 순서
    private Integer categoryDepth; // 0 : 상위 카테고리 1 : 하위카테고리
    private Integer upperKey;      // 대분류(카테고리 구분키 참조)

}
