package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/* Dto 작성 시, 테이블의 컬럼 다 넣지 않고 사용할 컬럼만 변수로 만들면 됨
* 하지만 JPA 에서는 엔티티라는 것을 만들기 때문에 테이블과 일치해줘야 함 */
public class CategoryDto {

    private Integer categoryKey;
    private String categoryName;
    private Integer categoryDepth;
    private Integer upperKey;

}
