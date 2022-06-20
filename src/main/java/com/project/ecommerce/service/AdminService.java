package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.mapper.AdminMapper;
import com.project.ecommerce.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /*
    * 타입하고 순서만 맞으면 파라미터(변수) 이름이 달라도 상관없음
    * */

    public void input(CategoryDto categoryDto) { // select 가 아니기 때문에 넣어주기만 하면되서 리턴값 필요없음
        adminMapper.insertCategory(categoryDto);
    }

    public List<CategoryDto> search() {
        return adminMapper.selectCategory();
    }

    public List<CategoryDto> remove(Integer categoryKey) { return adminMapper.deleteCategory(categoryKey); }
}

