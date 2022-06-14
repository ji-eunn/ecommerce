package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<CategoryDto> selectCategory();
    CategoryDto selectCategoryById();
}
