package com.project.ecommerce.controller;

import com.project.ecommerce.dto.AccountDto;
import com.project.ecommerce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    /**
     * 회원 가입 페이지
     */
    @GetMapping("/joinPage")
    public String joinPage() {
        return "/member/account/join.html";
    }

    /**
     * 회원 등록
     */
    @PostMapping("/join")
    public String joinLogic(AccountDto memberDto, Model model) {

        if (accountService.join(memberDto) == 0) {
            model.addAttribute("error", 1);
            return "/member/account/join.html";
        }
        return "/member/account/login.html";

    }

    /**
     * 회원 정보 페이지
     */
    @GetMapping("/detailPage/{memberKey}")
    public String detailPage(Model model, @PathVariable("memberKey") Integer memberKey) {
//        int memberKey = 1;
        AccountDto accountDto = accountService.searchByKey(memberKey);
        model.addAttribute("account", accountDto);
        return "/member/account/detail.html";
    }

    /**
     * 회원 수정 페이지
     */
    @GetMapping("/editPage/{memberKey}")
    public String editPage(@PathVariable("memberKey") Integer memberKey, Model model) {
        AccountDto accountDto = accountService.searchByKey(memberKey);
        model.addAttribute("account", accountDto);
        return "/member/account/edit.html";
    }

    /**
     * 회원 수정
     */
    @PostMapping("/edit/{memberKey}")
    public String editLogic(Model model, AccountDto accountDto) {
        AccountDto updatedAccount = accountService.edit(accountDto);
        model.addAttribute("account", updatedAccount);
        return "/member/account/detail.html";
    }

    /**
     * 회원 탈퇴
     */
    @PostMapping("/remove")
    @ResponseBody
    public Integer remove(@RequestBody Integer memberKey) {
        accountService.remove(memberKey);
        return memberKey;
    }

    /**
     * 회원 목록 페이지
     */
    @GetMapping("/listPage")
    public String list(Model model) {
        List<AccountDto> accountDto = accountService.search();
        model.addAttribute("account", accountDto);
        return "admin/account/list.html";
    }

    /**
     * 로그인 페이지
     */
    @GetMapping("/loginPage")
    public String loginPage() { return "/member/account/login.html"; }
//
//
//    /**
//     * 로그인
//     */
//    @PostMapping("/login")
//    public String loginLogic(MemberDto memberDto, HttpServletRequest request, Model model) {
//
//        String forward = "";
//        accountService.login(memberDto);
//
//        // 로그인 성공
//        if(memberDto.getMemberKey() > 0) {
//            HttpSession session = request.getSession();
//            session.setAttribute("account", memberDto);
//            session.setAttribute("logined", true);
//
//            forward = "redirect:/";
//        // 로그인 실패
//        } else {
//            model.addAttribute("data", memberDto);
//            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
//            forward = "/member/account/login.html";
//        }
//
//        return forward;
//    }


}
