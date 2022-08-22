package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void addProduct(ProductDto productDto) {
        productMapper.createProduct(productDto);
    }

    public List<ProductDto> search() {
        return productMapper.selectProduct();
    }

    public ProductDto searchByKey(Integer productKey) {
        return productMapper.selectProductByKey(productKey);
    }

    public ProductDto edit(ProductDto productDto) {
        productMapper.updateProduct(productDto);
        return searchByKey(productDto.getProductKey());
    }

    public void remove(List<Integer> productKeyArray) {
//        for(int i = 0; i < productKeyArray.size(); i++) {
//            productMapper.deleteProduct(productKeyArray.get(i));
//        }
        productMapper.deleteProduct(productKeyArray);
    }

    public List<CategoryDto> searchCategory() {
        return productMapper.selectCategory();
    }

}
