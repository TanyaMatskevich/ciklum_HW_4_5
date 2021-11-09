package com.ciklum.ciklumhybristesttask.controller;

import com.ciklum.ciklumhybristesttask.dto.ProductDto;
import com.ciklum.ciklumhybristesttask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String showProductForm(ProductDto productDto) {
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(ProductDto productDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-product";
        }
        productService.save(productDto);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "products";
    }

    @PostMapping("/edit/{id}")
    public void addAndUpdate(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable String id, Model model) {
        int idForDeletion = Integer.parseInt(id);
        productService.delete(idForDeletion);
        return "redirect:/products";
    }
}
