package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void createProduct(ProductDto productDto);

    List<ProductDto> selectProduct();

    ProductDto selectProductByKey(@Param("productKey") Integer productKey);

    void updateProduct(ProductDto productDto);

    void deleteProduct(List<Integer> productKeyArray);

    List<CategoryDto> selectCategory();

    int deleteCheckedProduct(Integer productKey);
}
