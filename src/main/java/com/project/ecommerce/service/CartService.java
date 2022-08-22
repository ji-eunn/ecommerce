package com.project.ecommerce.service;

import com.project.ecommerce.dto.CartDto;
import com.project.ecommerce.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {


    private final CartMapper cartMapper;

    public List<CartDto> findAll(Integer memberKey) {
        return cartMapper.selectAll(memberKey);
    }

    public void add(CartDto cartDto, Integer memberKey) {
        cartMapper.insert(cartDto, memberKey);
    }

    public void checkedRemove(List<Integer> productKeyArray) {
        cartMapper.checkedRemove(productKeyArray);
    }
}
