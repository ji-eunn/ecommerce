package com.project.ecommerce.controller;

import com.project.ecommerce.dto.DeleteOrderDto;
import com.project.ecommerce.dto.OrderDto;
import com.project.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/order")
@RequiredArgsConstructor
public class AjaxOrderController {

    private final OrderService orderService;

    /**
     * 주문 생성
     */
    @PostMapping
    public Integer createOrder(OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return 1;
    }

    /**
     * 주문 조회
     */
    @GetMapping("/{orderKey}")
    public OrderDto searchOrder(@PathVariable("orderKey") Integer orderKey) {
        return orderService.searchByKey(orderKey);
    }

    /**
     * 주문 수정 (이름, 주소, 연락처)
     */
    @PutMapping
    public OrderDto editOrder(@RequestBody OrderDto orderDto) {
        return orderService.edit(orderDto);
    }

    /**
     * 주문 취소
     */
    @DeleteMapping
    public Integer removeOrder(@RequestBody DeleteOrderDto deleteOrderDto) {
        orderService.remove(deleteOrderDto.getOrderKeyArray());
        return 1;
    }
}
