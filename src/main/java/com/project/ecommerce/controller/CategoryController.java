package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
* ID NAME DEGREE UPPER_ID
* 1  test  1     null
* 2  test2 2     1
* 3  test3 1     null
* 4  test4 2     1
*
* */


@Controller // Controller : Model 을 이용해 데이터를 가져오고 View 에 데이터를 넘겨 적절한 View 를 생성하는 역할

// Controller 는 항상 화면단위가 같이 가야한다.
// 예를들어, 네이버에서 버튼을 클릭했을 때 페이지가 새로고침되며 페이지 전체가 다 같이 반환된다.
// 하지만, 이런 Controller 에서도 @ResponseBody 를 사용하면 RestController 처럼 쓸 수가 있다.
// 메소드에 @ResponseBody 를 붙이면 꼭 화면을 return 하지 않아도 데이터만 return 할 수 있다.

/*
    @GetMapping("/category/list")
    @ResponseBody
    public List<CategoryDto> list(Model model) {
        List<CategoryDto> categoryDto = adminService.search();
        model.addAttribute("category", categoryDto);
        return categoryDto;
    }
* */

@RequestMapping(path = "/admin")
public class CategoryController {

     /*
     * 의존성 주입
     Java 는 객체지향언어로 클래스끼리 서로 연결되어 있지 않다.
     그렇기 때문에 @Autowired 를 사용해서 연결해주는데 이 연결해준 것을
     로직 안에서만 쓰겠다해서 private 접근제한자를 붙여주는 것이다.
     그럼 왜 로직 안에서만 쓰려고 하는걸까?
     자바의 특징 중 하나인 '캡슐화' 때문이다.
     캡슐화는 데이터를 보호하기 위함인데 로직안에서 쓰게 할 수 있음 그게 좋다는 걸 의미한다.
     * */

    @Autowired
    private CategoryService adminService;

    // 동일 Controller 내, 전체 프로젝트 내에서도 에서 mapping(@RequestMapping(value="") 은 중복X -> 에러 발생
    // 특이한 점은 메소드가 달라지면 중복 가능 -> '다형성'

    /**
     * 카테고리 등록페이지
     */
    @GetMapping("/category/registerPage")
    public String createPage(Model model) {
        List<CategoryDto> topLevelCategory = adminService.searchCategory();
        model.addAttribute("topLevelCategory", topLevelCategory);
        return "admin/category/register.html";
    }

    /*
    *
    * 메소드 파라미터로 html 에서 categoryName 만 넘겨주기 때문에
                                                         // public String createLogin(String categoryName) 과 같이 html 에서 넘겨준 name 만 넣어줘도 되지만
                                                         // 이게 1개가 아니라 여러개일 경우 너무 많아지므로
                                                         // Dto 가 있으면 Dto 넣어주는 게 좋다.
    *
    * */

    /**
     * 카테고리 등록
     */
    @PostMapping("/category/register")
    public String createLogic(CategoryDto categoryDto) { // 파라미터는 타입과 순서만 맞으면 이름이 달라도 상관없다.
                                                         // 즉, createLogic(CategoryDto categoryDto) 이라 작성하고
                                                         // input 메소드에서는 categoryDto2 로 써도됨
        //        System.out.println(categoryDto);
        adminService.input(categoryDto); // input 을 해줄 때 파라미터로 categoryDto 전달. 그럼 Mybatis 에서 알아서 mapper 의 #{} 에 있는거 찾아서 넣어준다.
        return "redirect:/admin/category/listPage";
    }

    /*
    보통 CRUD 메소드명 작성 시,
    서비스단에서는 input(create) / search / remove 과 같이 사용하시고
    DB 랑 관련되어 있으면 insert / select / update / delete 사용
    * */

    /**
     * 카테고리 목록페이지
     */
    @GetMapping("/category/listPage")
    public String list(Model model) { // Model : Controller 에서 생성된 데이터를 담아 View 로 전달할 때 사용하는 객체
        List<CategoryDto> categoryDto = adminService.search();
        model.addAttribute("category", categoryDto);
        // model.addAttribute("key", "value");
        return "admin/category/list.html";
    }

    /*
    * @PathVariable : mapping 경로에서 categoryKey 를 받아와서 변수를 만들기.
    * */

    /* 500 에러 = 서버 에러 -> Intellij 에서 로그를 보고 실제 가동하는 서버일 경우, 실제 서버의 로그를 봐야 함 */

    /**
     * 카테고리 삭제
     */
    @GetMapping("/category/remove/{categoryKey}")
    public String remove(@PathVariable("categoryKey") Integer categoryKey) {
        adminService.remove(categoryKey);
        return "redirect:/admin/category/listPage";
    }

    /**
     * 카테고리 상세페이지, 수정페이지
     * Pathvaraible 경로로 받아오면 좋음
     */
    @GetMapping("/category/detailPage/{categoryKey}")
    public String detailPage(@PathVariable("categoryKey") Integer categoryKey, Model model) {
        CategoryDto categoryDto = adminService.searchByKey(categoryKey);
        model.addAttribute("category", categoryDto);
        return  "admin/category/detail.html";
    }

    @GetMapping("/category/editPage/{categoryKey}")
    // @PathVariable : 경로 변수 (uri 에 있는 무언가를 자바 변수로 받는 것)
    public String editPage(@PathVariable("categoryKey") Integer categoryKey, Model model) {
        CategoryDto categoryDto = adminService.searchByKey(categoryKey);
        model.addAttribute("category", categoryDto);
        return "admin/category/edit.html";
    }

    /* 디버깅 과정
    * 1. 경로가 제대로 바인딩 되지 않음 -> return 값에 uri 의 categoryKey 가 그대로 들어감(자바 문법에는 존재하지 않음)
    * 2. categoryName 이 null -> 우선, DB 쪽에 categoryName 이 전달 안될 확률이 조금 있을 것 같다
    * 컨트롤러에서 CategoryDto 에 categoryName 이 잘 올라오고 있는지 확인했어야 했으나..선생님은 경험상 생략
    * -> categoryName 이 DB 에는 잘 전달되고있었음을 확인
    * edit.html 페이지에서 input 의 name 에 들어간것이 컨트롤러에서 받는 변수형식인 Dto 와 매칭이 잘 되고, form 에 있는 action 경로가 컨트롤러의 다음 갈 곳인 매핑과 잘 연결되어있으며
    * button이 submit 으로 잘 되어있을 경우 문제가 없다고 판단.
    * 3. return 하는 곳으로 이동 -> thymeleaf 문법이 쓰였음을 판단
         타임리프 문법이 애초에 서버에서 가져오는 데이터를 표현하기 위한 건데
         서버에서는 아무 데이터도 보내주고 있지 않았음(Model 에 아무것도 안넣었음)
         *서버에서 데이터를 보내주는 방법은 여러가지가 있으나
         * 스프링 부트에서는 대부분 Model 에 담아서 보내준다.
    */
    @PostMapping("/category/edit/{categoryKey}")
    public String editLogic(@PathVariable("categoryKey") Integer categoryKey,
                            CategoryDto categoryDto, Model model) {
        CategoryDto categoryDto1 = adminService.edit(categoryDto);
        model.addAttribute("category", categoryDto1);
        return "admin/category/detail.html";
    }


    // 권한 테이블 추가 필요(관리자/일반 사용자 구분)

    /*
    * 추가페이지도 구현
    * */

}
