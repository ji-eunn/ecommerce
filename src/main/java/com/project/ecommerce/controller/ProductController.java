package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// application.yml -> port 변경
@Controller
@RequestMapping(path= "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 등록 페이지
     */
    @GetMapping("/registerPage")
    public String createPage(Model model) {
        List<CategoryDto> category = productService.searchCategory();
        model.addAttribute("category", category);
        return "admin/product/register.html";
    }

    /**
     * 상품 등록
     */
    @PostMapping("/register")
    public String createLogic(ProductDto productDto) {
        productService.addProduct(productDto);
        return "redirect:/admin/product/listPage";
    }

    /**
     * 상품 목록 페이지
     */
    @GetMapping("/listPage")
    public String list(Model model) {
        List<ProductDto> productDto = productService.search();
        model.addAttribute("product", productDto);
        return "admin/product/list.html";
    }

    /**
     * 상품 상세 페이지
     */
    @GetMapping("/detailPage/{productKey}")
    public String detailPage(@PathVariable("productKey") Integer productKey, Model model) {
        ProductDto productDto = productService.searchByKey(productKey);
        model.addAttribute("product", productDto);
        return "admin/product/detail.html";
    }

    /**
     * 상품 수정 페이지
     */
    @GetMapping("/editPage/{productKey}")
    public String editPage(@PathVariable("productKey") Integer productKey, Model model) {
        ProductDto productDto = productService.searchByKey(productKey);
        model.addAttribute("product", productDto);
        return "admin/product/edit.html";
    }

    /**
     * 상품 수정
     */
    @PostMapping("/edit/{productKey}")
    public String editLogic(@PathVariable("productKey") Integer productKey, Model model,
                            ProductDto productDto) {
        ProductDto updatedProduct = productService.edit(productDto);
        model.addAttribute("product", updatedProduct);
        return "admin/product/detail.html";
    }


}
