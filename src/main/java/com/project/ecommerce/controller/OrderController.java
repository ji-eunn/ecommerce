package com.project.ecommerce.controller;

import com.project.ecommerce.dto.OrderDto;
import com.project.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Integer createOrder(OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return 1;
    }
}
