package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CartDto;
import com.project.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 중간 중간 안쓰는 건 리팩토링 */

@RestController
// @RestController = ResponseBody + Controller 이기 때문에 @ResponseBody 안써줘도 됨
public class CartController { // 장바구니는 쿠키(Cookie) 이용

    // REST FUL API 정리

    @Autowired
    CartService cartService;

    // 조회, 등록 모두 개인 조회 key 를 받으면 key 로 조회할 수 있도록 @PathVariable 사용
    @GetMapping("/cart/listPage/{memberKey}")
    public List<CartDto> list(@PathVariable("memberKey") Integer memberKey) {
        List<CartDto> cart = cartService.findAll(memberKey);
        return cart;
    }

    // 등록은 DB 에 넣기만 하는 거니까 원래는 반환값이 없지만
    // 반환 타입을 int 로 주고 성공하면 1, 실패하면 0 이런식으로 할 수도 있음
    @PostMapping("/cart/add/{memberKey}")
                 /*
                 html 에서 등록하기 위해 작성한 정보를 Controller 에서 받아야 하니까
                 add 메소드의 파라미터로 CartDto cartDto 를 넣어준 것
                 Integer cartKey, String prdName 과 같이 하나하나 작성해줄 수도 있지만
                 CartDto 객체를 가져다가 한꺼번에 쓸 수 있음
                  */
    public void add(@PathVariable("memberKey") Integer memberKey,
                    CartDto cartDto) {
        cartService.add(cartDto, memberKey);
    }
    /* 화면 단위는 없고 API 만 있을 경우,
    * POST 방식을 테스트 하기 위해 API 테스팅 툴 사용
    * 예) POSTMAN, INSOMNIA
    * Query 탭에 데이터도 넣어줘야 함
    * */

    @PostMapping("/cart/remove")
    @ResponseBody
    public List<Integer> remove(@RequestBody List<Integer> productKeyArray) {
        cartService.checkedRemove(productKeyArray);
        return productKeyArray;
    }

}

/*
* 기능별로 Git 에 올리기
* 예) Product 에 대한 거
* 원래는 작업 끝날떄마다 하는 게 좋음
* */