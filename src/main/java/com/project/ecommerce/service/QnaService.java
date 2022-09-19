package com.project.ecommerce.service;

import com.project.ecommerce.dto.QnaDto;
import com.project.ecommerce.mapper.QnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaMapper qnaMapper;

    public void createQna(QnaDto qnaDto) {
        qnaMapper.insertQna(qnaDto);
    }

    public List<QnaDto> search() {
        return qnaMapper.selectQna();
    }

    public QnaDto searchByKey(Integer qnaKey) {
        return qnaMapper.selectQnaByKey(qnaKey);
    }

    public QnaDto edit(QnaDto qnaDto) {
        qnaMapper.updateQna(qnaDto);
        return searchByKey(qnaDto.getQnaKey());
    }

    public void remove(List<Integer> qnaKeyArray) {
        qnaMapper.deleteQna(qnaKeyArray);
    }
}
