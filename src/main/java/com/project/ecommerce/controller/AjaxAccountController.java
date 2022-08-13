package com.project.ecommerce.controller;

import com.project.ecommerce.dto.AccountDto;
import org.json.simple.JSONObject;
import com.project.ecommerce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member", produces = "application/json; charset=utf-8")
public class AjaxAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/email")
    public String confirmEmail(@RequestParam String email) throws Exception {
        boolean res = accountService.confirmEmail(email);

        JSONObject json = new JSONObject();
        if (res) {
            json.put("result", true);
        } else {
            json.put("result", false);
        }
        return json.toJSONString();
    }

    /* 회원 가입 */
    /*RESTful API 구조에서 무언가의 등록 API 는
     * POST Method 사용 */
    @PostMapping
    public Integer joinLogic(AccountDto accountDto, Model model) {
        if (accountService.join(accountDto) == 0) {
            model.addAttribute("error", 1);
            return 0;
        } else {
            return 1;
        }
    }

    // api 만들 때 DB 부터 작업
    // getMapping 은 url 로 바로 조회 가능
    /* 회원 전체 조회 */
    /* 전체 조회는 member + GET */
    @GetMapping
    public List<AccountDto> findList() { // service 에서 필요없으면 여기서도 파라미터 값 필요없음
        return accountService.search();
    }

    /* 회원 개별 조회 */
    /* 개별 조회는 member/id + GET */
    @GetMapping("/{memberKey}")
    /*경로에서 변수를 사용하려면 {}로 감싸고
     * 이것을 자바 변수로 쓰러면 PahtVariable 어노테이션으로 바꿔야한다.. */
    public AccountDto detailPage(@PathVariable("memberKey") Integer memberKey) {
//        int memberKey = 1;
        return accountService.searchByKey(memberKey);
    }

    /* 회원 개별 수정 */
    /* 수정은 member/id + PUT */
    @PutMapping("/{memberKey}")
    public AccountDto editLogic2(AccountDto accountDto) {
        return accountService.edit(accountDto);
    }
    // insomnia 에서 테스트할 때 POST 는 JSON 형식으로 데이터도 넣어줘야 함
    // 회원 개별 수정할거니 수정할 데이터 넣어주기

    /* 회원 삭제 */
    @DeleteMapping("/{memberKey}")
    public Integer removeLogic(@PathVariable("memberKey") Integer memberKey) { // dto 로 받는 걸 추천 (안전)
        accountService.remove(memberKey);
        return memberKey;
    }
// Ctrl Shift f12

}
