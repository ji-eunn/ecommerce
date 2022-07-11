package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
// Mapper 의 Interface 클래스도 하나 만들어줘야 Java 와 매칭을 할 수 가 있다.
// Mapper 는 자바의 구성요소가 아니고 mybatis 의 구성요소이기 때문에
// 매칭하기 위해 Mapper 클래스가 있는 것
// 즉, resources > mapper > AdminMapper 생성 / com.project.ecommerce > mapper > AdminMapper 도 생성
// 생성하지 않았을 경우 오류 발생
public interface CategoryMapper {

/*    insert, update, delete 는 리턴값이 없어 void 를 쓰지만
    int 를 리턴받을 수도 있다.
    결과값으로 int 를 리턴받아 0이면 실패, 1이면 성공 과 같이 구분하여 사용하는게 좀 더 좋은 로직이다.*/

    int insertCategory(CategoryDto categoryDto);

    List<CategoryDto> selectCategory();
    /*
    * 그냥 넣으면 MyBatis XML 에서 인지하지 못할 수 도 있으니, @Param 으로 정의해줘야 한다.
    * BUT.  DTO 로 사용하면 정의해주지 않아도 잘 인지한다.
    * */
    void deleteCategory(@Param("categoryKey") Integer categoryKey);

    CategoryDto selectCategoryByKey(@Param("categoryKey") Integer categoryKey);

    void updateCategory(CategoryDto categoryDto);

    List<CategoryDto> selectTopLevelCategory();
}
