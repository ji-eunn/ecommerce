package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper adminMapper;

    /*
    * 타입하고 순서만 맞으면 파라미터(변수) 이름이 달라도 상관없음
    * */

    public void input(CategoryDto categoryDto) { // select 가 아니기 때문에 넣어주기만 하면되서 리턴값 필요없음
        adminMapper.insertCategory(categoryDto);
    }

    public List<CategoryDto> search() {
        return adminMapper.selectCategory();
    }

    public void remove(Integer categoryKey) { adminMapper.deleteCategory(categoryKey); }

    public CategoryDto searchByKey(Integer categoryKey) {
        return adminMapper.selectCategoryByKey(categoryKey);
    }

    /*
    * 서비스는 비즈니스 로직이 있는 곳으로 실제 코드가 제일 많아야 한다.
    즉, 컨트롤러에서 두 번 메소드를 호출하는 것보다 서비스에서 모든 로직을 처리하고 한 번에 보내주는 것이 맞다.
     */
    public CategoryDto edit(CategoryDto categoryDto) {
        adminMapper.updateCategory(categoryDto);
        return searchByKey(categoryDto.getCategoryKey());
    }

    /*
    Ctrl + 메소드명 클릭 : 해당 메소드가 사용된 곳으로 이동
    Ctrl + Alt + 메소드명 클릭 : 가끔 ServiceImpl 구조가 있는데, 이럴 때는 실제 상속받는 곳에서 메소드가 쓰이기 때문에 해당 위치로 이동
    Ctrl + Alt 로 쓰면 됨
    * */
}

