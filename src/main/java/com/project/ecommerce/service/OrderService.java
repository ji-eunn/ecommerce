package com.project.ecommerce.service;

import com.project.ecommerce.dto.OrderDto;
import com.project.ecommerce.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public void addOrder(OrderDto orderDto) {
        orderMapper.insert(orderDto);
    }
}
