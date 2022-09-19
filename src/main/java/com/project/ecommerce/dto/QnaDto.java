package com.project.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class QnaDto {

    private Integer qnaKey;
    private String qnaTitle;
    private String qnaPwd;
    // qna_pwd
    // 1. 로그인을 했을 때 세션으로 구분
    // 2. pwd 컬럼으로 구분
    private String qnaWriter;
    private String qnaContent;
    private String qnaCategory;
    private Timestamp qnaTime;
    private Integer views;
    private String lockFlag;

}
