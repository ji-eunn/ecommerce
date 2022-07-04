package com.project.ecommerce.service;

import com.project.ecommerce.dto.CartDto;
import com.project.ecommerce.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;

    public List<CartDto> findAll() {
        return cartMapper.selectAll();
    }

    public void add(CartDto cartDto) {
        cartMapper.insert(cartDto);
    }
}
