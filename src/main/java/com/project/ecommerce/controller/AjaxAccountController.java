package com.project.ecommerce.controller;

import com.project.ecommerce.dto.AccountDto;
import org.json.simple.JSONObject;
import com.project.ecommerce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ajax/account")
public class AjaxAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/email", produces = "application/json; charset=utf-8")
    public String confirmEmail(@RequestParam String email) throws Exception {
        boolean res = accountService.confirmEmail(email);

        JSONObject json = new JSONObject();
        if(res) {
            json.put("result", true);
        } else {
            json.put("result", false);
        }
        return json.toJSONString();
    }

    @PostMapping(value = "/joinLogic", produces = "application/json; charset=utf-8")
    public Integer joinLogic (AccountDto accountDto, Model model) {
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
    @GetMapping(value = "/list", produces = "application/json; charset=utf-8")
    public List<AccountDto> findList () { // service 에서 필요없으면 여기서도 파라미터 값 필요없음
        return accountService.search();
    }

    /* 회원 개별 조회 */
    @GetMapping(value = "/detailPage/{memberKey}", produces = "application/json; charset=utf-8")
    public AccountDto detailPage() {
        int memberKey = 1;
        return accountService.searchByKey(memberKey);
    }

    /* 회원 개별 수정 */
    @PostMapping(value = "/edit2/{memberKey}", produces = "application/json; charset=utf-8")
    public AccountDto editLogic2(AccountDto accountDto) {
        return accountService.edit(accountDto);
    }


}
