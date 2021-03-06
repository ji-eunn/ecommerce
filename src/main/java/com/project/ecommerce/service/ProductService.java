package com.project.ecommerce.service;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

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

    public void remove(Integer productKey) {
        productMapper.deleteProduct(productKey);
    }

    public List<CategoryDto> searchCategory() {
        return productMapper.selectCategory();
    }

    public void checkedRemove(List<Integer> productKeyArray) {
   /*     for(int j = 0; j < productKeyArray.size(); j++) {
            // productKey   2 4 6 7
            // i            0 1 2 3

                productMapper.deleteCheckedProduct(productKeyArray.get(j));
        }*/

        // productKeyArray.get(i) -> productKey
        // Integer 인 이유는 List<Integer> productKeyArray 로 데이터타입을 Integer 로 선언해주었기 때문
        for(Integer productKey : productKeyArray) {
            productMapper.deleteCheckedProduct(productKey);
        }

    }
}
