package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
 RestController 는 페이지 전체 화면단위가 다 같이 반환되는 게 아니고, 데이터만 반환된다(json 데이터로 반환)
 RestAPI : 데이터(=URI, 즉 자원) 에 대한 HTTP CRUD(GET,POST,PUT,DELETE) 를 나타내는 기법.
 RESTAPI 에서 무언가 등록 API 는 POST Method , 조회 시에는 GET Method, 수정 시에는 Put Method, 삭제 시에는 Delete Method 사용한다.
 RESTAPI 를 만들 때는 DB 부터 작업하는 것이 좋다.
 URI : https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html
 URL : https://gmlwjd9405.github.io
 RestController : RestAPI + Controller = ResponseBody + Controller
 공공데이터 API : 우리의 데이터를 어디서든 쓸 수 있는 것
 즉, @RestController 는 RestAPI 를 제공
 */


@RestController 
@RequiredArgsConstructor
public class AdminRestController {
    
    private final CategoryService adminService;

    @GetMapping("/test")
    public List<CategoryDto> test() {
        return adminService.search();
    }

}
