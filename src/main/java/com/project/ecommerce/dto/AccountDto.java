package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AccountDto {

    private Integer memberKey;
    private String memberName;
    private String email;
    private String password;
    private Integer phone;
    private Timestamp createTime;
    private Integer delFlag;
    private Timestamp delTime;
    private Integer pasWrong; // 비밀번호 불일치 횟수
    private Integer role;     // 0 - 일반사용자, 1 - 관리자
    private Timestamp loginTime;
}
