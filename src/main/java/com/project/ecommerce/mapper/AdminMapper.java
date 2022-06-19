package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// Mapper 의 Interface 클래스도 하나 만들어줘야 Java 와 매칭을 할 수 가 있다.
// Mapper 는 자바의 구성요소가 아니고 mybatis 의 구성요소이기 때문에
// 매칭하기 위해 Mapper 클래스가 있는 것
// 즉, resources > mapper > AdminMapper 생성 / com.project.ecommerce > mapper > AdminMapper 도 생성
// 생성하지 않았을 경우 오류 발생
public interface AdminMapper {

    void insertCategory(CategoryDto categoryDto);

}
