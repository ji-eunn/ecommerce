package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountDto {

    private Integer memberKey;
/*    private String memberId;*/
    private String memberName;
    private String email;
    private String password;
    private Integer phone;
    private Date createTime;
    private Integer delFlag;
    private Date delTime;
    private Integer pasWrong; // 비밀번호 불일치 횟수
    private Integer role; // 0 - 일반사용자, 1 - 관리자
    private Date loginTime;

}
