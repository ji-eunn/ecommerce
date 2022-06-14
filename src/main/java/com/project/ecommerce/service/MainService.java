package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public List<CategoryDto> search() {
        return mainMapper.selectCategory();
    }

    public CategoryDto searchTwo() {
        return mainMapper.selectCategoryById();
    }

}
