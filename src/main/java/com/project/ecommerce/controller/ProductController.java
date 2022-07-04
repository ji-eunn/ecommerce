package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.ProductDto;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// application.yml -> port 변경
@Controller
@RequestMapping(path= "/admin")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 상품 등록페이지
     */
    @GetMapping("/product/registerPage")
    public String createPage(Model model) {
        List<CategoryDto> category = productService.searchCategory();
        model.addAttribute("category", category);
        return "admin/product/register.html";
    }

    /**
     * 상품 등록
     */
    @PostMapping("/product/register")
    public String createLogic(ProductDto productDto) {
        productService.addProduct(productDto);
        return "redirect:/admin/product/listPage"; // 등록하면 목록페이지로 이동되도록 처리
    }

    /**
     * 상품 목록페이지
     */
    @GetMapping("/product/listPage")
    public String list(Model model) {
        List<ProductDto> productDto = productService.search();
        model.addAttribute("product", productDto);
        return "admin/product/list.html";
    }

    /**
     * 상품 상세페이지
     */
    @GetMapping("/product/detailPage/{productKey}")
    public String detailPage(@PathVariable("productKey") Integer productKey, Model model) {
        ProductDto productDto = productService.searchByKey(productKey);
        model.addAttribute("product", productDto);
        return "admin/product/detail.html";
    }

    /**
     * 상품 수정페이지
     */
    @GetMapping("/product/editPage/{productKey}")
    public String editPage(@PathVariable("productKey") Integer productKey, Model model) {
        ProductDto productDto = productService.searchByKey(productKey);
        model.addAttribute("product", productDto);
        return "admin/product/edit.html";
    }

    /**
     * 상품 수정
     */
    @PostMapping("/product/edit/{productKey}")
    public String editLogic(@PathVariable("productKey") Integer productKey, Model model,
                            ProductDto productDto) {
        ProductDto updatedProduct = productService.edit(productDto);
        model.addAttribute("product", updatedProduct);
        return "admin/product/detail.html";
    }

    /**
     * 상품 삭제
     */
    @GetMapping("/product/remove/{productKey}")
    public String remove(@PathVariable("productKey") Integer productKey) {
        productService.remove(productKey);
        return "redirect:/admin/product/listPage";
    }

    /**
     * 상품 선택 삭제
     */
    @PostMapping("/product/checked/remove")
    @ResponseBody
    public List<Integer> remove(@RequestBody List<Integer> productKeyArray) { // DB 에서 productkey 의 데이터타입을 int 로 설정했기 때문에 자바에서 Integer 로 선언해줌. productKeyArray 는 productKey 를 여러개 받은 것이므로 List<Integer> 로 선언해주면 되는데, 다른 사람 코드 그대로 가져다 쓰다보니 String 으로 작성하여 ClassCastException 발생
        productService.checkedRemove(productKeyArray);
        return productKeyArray;
    }

}
