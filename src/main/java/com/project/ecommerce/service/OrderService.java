package com.project.ecommerce.service;

import com.project.ecommerce.dto.OrderDto;
import com.project.ecommerce.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public void addOrder(OrderDto orderDto) {
        orderMapper.insert(orderDto);
    }

    public OrderDto searchByKey(Integer orderKey) {
        return orderMapper.selectOrderByKey(orderKey);
    }

    public OrderDto edit(OrderDto orderDto) {
        orderMapper.updateOrder(orderDto);
        return searchByKey(orderDto.getOrderKey());
    }

    public void remove(List<Integer> orderKeyArray) {
        orderMapper.deleteOrder(orderKeyArray);
    }
}
