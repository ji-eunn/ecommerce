package com.project.ecommerce.controller;

import org.json.simple.JSONObject;
import com.project.ecommerce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ajax/account")
public class AjaxAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/email", produces = "application/json; charset=utf-8")
    @ResponseBody
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
}
