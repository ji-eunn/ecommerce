package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainMapper mainMapper;

    public List<CategoryDto> search() {
        return mainMapper.selectCategory();
    }

    public CategoryDto searchTwo() { return mainMapper.selectCategoryById(); }

}
