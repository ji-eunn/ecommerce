package com.project.ecommerce.controller;

import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/product", produces ="application/json")
@RequiredArgsConstructor
public class AjaxProductController {

    private final ProductService productService;

/*
    생성자 의존성 주입
    @Autowired
    AjaxProductController(ProductService productService) {
        this.productService = productService;
    }
*/

    /*
     * 상품 전제 조회
     */
    @GetMapping
    public List<ProductDto> findList() { return productService.search(); }

    /*
     * 상품 개별 조회
     */
    @GetMapping("/{productKey}")
    public ProductDto detailPage(@PathVariable("productKey") Integer productKey) {
        return productService.searchByKey(productKey);
    }

    /**
     * 상품 개별 수정
     */
    @PutMapping
    public ProductDto editLogic(@RequestBody ProductDto productDto) {
        return productService.edit(productDto);
    }

    /**
     * 상품 삭제
     */
    @DeleteMapping
    public Integer removeLogic(@RequestBody List<Integer> productKeyArray) {
        productService.remove(productKeyArray);
        return 1;
    }


}
