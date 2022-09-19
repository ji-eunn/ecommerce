package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.QnaDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaMapper {
    void insertQna(QnaDto qnaDto);

    List<QnaDto> selectQna();

    QnaDto selectQnaByKey(@Param("qnaKey") Integer qnaKey);

    void updateQna(QnaDto qnaDto);

    void deleteQna(List<Integer> qnaKeyArray);

}
