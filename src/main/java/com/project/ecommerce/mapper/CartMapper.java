package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CartDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// Mapper -> Mybatis mapper 랑 연결해주는 역할이므로 실기능이 별로 없다. 따라서 class 가 아닌 interface 로 구현한다.
public interface CartMapper {

    List<CartDto> selectAll(Integer memberKey);

    void insert(CartDto cartDto, Integer memberKey);

    void checkedRemove(List<Integer> productKeyArray);
}
