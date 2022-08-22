package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void insert(OrderDto orderDto);
}