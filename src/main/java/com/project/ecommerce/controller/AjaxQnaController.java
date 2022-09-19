package com.project.ecommerce.controller;

import com.project.ecommerce.dto.DeleteQnaDto;
import com.project.ecommerce.dto.QnaDto;
import com.project.ecommerce.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/qna")
@RequiredArgsConstructor
public class AjaxQnaController {

    private final QnaService qnaService;

    /**
     * 문의 등록
     */
    @PostMapping
    public void register(QnaDto qnaDto) {
        qnaService.createQna(qnaDto);
    }

    /**
     * 문의 전체 조회
     */
    @GetMapping
    public List<QnaDto> findList() {
        return qnaService.search();
    }

    /**
     * 문의 개별 조회
     */
    @GetMapping("/{qnaKey}")
    public QnaDto detailPage(@PathVariable("qnaKey") Integer qnaKey) {
        return qnaService.searchByKey(qnaKey);
    }

    /**
     * 문의 개별 수정
     * @return
     */
    @PutMapping
    public QnaDto editLogic(@RequestBody QnaDto qnaDto) {
        return qnaService.edit(qnaDto);
    }

    /**
     * 문의 삭제
     */
    @PostMapping("/delete")
    public Integer removeLogic(@RequestBody DeleteQnaDto deleteQnaDto) {
        qnaService.remove(deleteQnaDto.getQnaKeyArray());
        return 1;
    }


}
