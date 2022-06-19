package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired // 의존성 주입
               // Java 는 객체지향언어로 서로 연결되어 있지 않다.
               // 그렇기 때문에 @Autowired  를 사용해서 연결해주는데 이 연결해준 것을
               // 로직 안에서만 쓰겠다해서 private 접근제한자를 붙여주는 것이다.
               // 그럼 왜 로직 안에서만 쓰려고 하는걸까?
               // 자바의 특징 중 하나인 '캡슐화' 때문이다.
               // 캡슐화는 데이터를 보호하기 위함인데 로직안에서 쓰게 할 수 있음 그게 좋다는 걸 의미한다.
    private AdminService adminService;

    // 동일 Controller 내, 전체 프로젝트 내에서도 에서 mapping(@RequestMapping(value="") 은 중복X -> 에러 발생
    // 특잏안 점은 메소드가 달라지면 중복O
    @GetMapping("/category/registerPage")
    public String createPage() {
        return "admin/category/register.html";
    }

    @PostMapping("/category/register")
    public String createLogic(CategoryDto categoryDto) { // 메소드 파라미터로 html 에서 categoryName 만 넘겨주기 때문에
                                                         // public String createLogin(String categoryName) 과 같이 html 에서 넘겨준 name 만 넣어줘도 되지만
                                                         // 이게 1개가 아니라 여러개일 경우 너무 많아지므로
                                                         // Dto 가 있으면 Dto 넣어주는 게 좋다.
        System.out.println(categoryDto);
        adminService.input(categoryDto); // input 을 해줄 때 파라미터로 categoryDto 전달. 그럼 Mybatis 에서 알아서 mapper 의 #{} 에 있는거 찾아서 넣어준다.
        return "admin/category/list.html";
    }
    // 보통 CRUD 메소드명 작성 시,
    // 서비스단에서는 input(create) / search / drop 과 같이 사용하시고
    // DB 랑 관련되어 있으면 insert / select / update / delete 사용





}
