package com.project.ecommerce.controller;

import com.project.ecommerce.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import com.project.ecommerce.service.AccountService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class AjaxAccountController {

    private final AccountService accountService;

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

    /**
     * 회원 가입
     */
    @PostMapping
    public Integer joinLogic(@RequestBody AccountDto accountDto, Model model) { // @RequestBody <- data : JSON.stringify() 으로 받는 건 @RequestBody 어노테이션 사용해줘야 함
        if (accountService.join(accountDto) == 0) {
            model.addAttribute("error", 1);
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 회원 전체 조회
     */
    @GetMapping
    public List<AccountDto> findList() { // service 에서 필요없으면 여기서도 파라미터 값 필요없음
        return accountService.search();
    }

    /**
     * 회원 개별 조회
     */
    @GetMapping("/{memberKey}") // uri 에서 변수를 사용하기위해 {}로 감싸고 이것을 자바 변수로 쓰기위해 @PathVariable 으로 바꿈 */
    public AccountDto detailPage(@PathVariable("memberKey") Integer memberKey) {
//        int memberKey = 1;
        return accountService.searchByKey(memberKey);
    }

    /**
     * 회원 개별 수정
     */
    @PutMapping("/{memberKey}")
    public AccountDto editLogic2(@RequestBody AccountDto accountDto) {
        return accountService.edit(accountDto);
    }

    /* 회원 삭제 */
    @DeleteMapping("/{memberKey}")
    public Integer removeLogic(@PathVariable("memberKey") Integer memberKey) {
        accountService.remove(memberKey);
        return memberKey;
    }


}

// Ctrl Shift f12 : 모든 창 숨기기 복원