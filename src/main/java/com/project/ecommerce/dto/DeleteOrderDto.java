package com.project.ecommerce.dto;

import lombok.Getter;

import java.util.List;

@Getter
/* Order 에 대한 Delete Rest API 테스트를 postman 에서 진행할 때 오류가 발생했다.
* 메소드에 대한 파라미터는 List<Integer> 였고,
* Body 에 데이터를 입력해줄 때
* {
    "orderKeyArray" : [1,2]
  }
* 와 같이 작성하였으나 계속 오류가 발생했다.
* 페이지에서는 삭제처리가 잘 되던 product 도 마찬가지였다
* 디버깅을 함수에 찍어서 변수가 들어올 때 부터도 봤지만 해당 메소드 자체에 걸리지 않았다.
* DeleteOrderDto 라는 메소드를 만들어서 파라미터값으로 List<Integer> orderKeyArray 대신
* 넣어주었더니 정상적으로 실행되었다.
* 메소드의 파라미터로 List<Integer> orderKeyArray 와 같이 생으로 정의하는 것보다는
* Dto 로 받는것이 더 안전하다.
  *  */
public class DeleteOrderDto {

    private List<Integer> orderKeyArray;

}
