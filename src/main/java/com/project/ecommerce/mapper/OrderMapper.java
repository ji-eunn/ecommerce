package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    void insert(OrderDto orderDto);

    OrderDto selectOrderByKey(@Param("orderKey") Integer orderKey);

    void updateOrder(OrderDto orderDto);

    void deleteOrder(List<Integer> orderKeyArray);
}