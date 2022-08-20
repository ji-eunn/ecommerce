package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CartDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    List<CartDto> selectAll(Integer memberKey);

    void insert(CartDto cartDto, Integer memberKey);

    void checkedRemove(List<Integer> productKeyArray);
}
