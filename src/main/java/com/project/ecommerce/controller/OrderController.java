package com.project.ecommerce.controller;

import com.project.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path= "/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    /**
     * 주문 목록 페이지
     */
    @GetMapping("/listPage")
    public String list() {
        return "cart.html";
    }




}
