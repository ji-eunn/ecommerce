package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.mapper.MainMapper;
import com.project.ecommerce.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {

    @Autowired
    MainService mainService;



    @GetMapping("/")
    public String indexPage() {
        return "cart.html";
    }


    @GetMapping("/index2")
    public String index() {
        // category 테이블에 데이터가 하나만 존재 할 경우,
        // CategoryDto 로 데이터를 가져올 수 있지만
        // 데이터가 하나 이상 존재하기 때문에 List<CategoryDto> 로 객체를 생성하여 담아준다.
        // 인덱스를 사용하여 데이터를 가져오고, 만약 모든 데이터를 가져오고 싶을 땐 for문(반복문)을 이용하여 가져온다.
        List<CategoryDto> categoryDto = mainService.search();
        System.out.println(categoryDto.get(0).getCategoryKey());
        System.out.println(categoryDto.get(0).getCategoryName());
        return "test.html";
    }

    @RequestMapping(value = "/index3", method=GET)
    public String indexTwo() {
        CategoryDto categoryDto = mainService.searchTwo(); // 하나 입력하면 입력란 하나 더 생겨서 하나 더 입력하고 여러개 한꺼버네 추가할 수있게
        System.out.println(categoryDto.getCategoryKey());
        return "test.html";
    }

}
