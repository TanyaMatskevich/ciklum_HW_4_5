package com.ciklum.ciklumhybristesttask.controller;

import com.ciklum.ciklumhybristesttask.dto.OrderDto;
import com.ciklum.ciklumhybristesttask.dto.OrderWithProductDto;
import com.ciklum.ciklumhybristesttask.dto.OrderedProductDto;
import com.ciklum.ciklumhybristesttask.dto.ProductDto;
import com.ciklum.ciklumhybristesttask.service.OrderService;
import com.ciklum.ciklumhybristesttask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String showOrderForm(OrderedProductDto orderDto, Model model) {
        model.addAttribute("orderDto", orderDto);
        return "add-order";
    }

    @PostMapping("/addOrder")
    public String addOrder(OrderedProductDto orderedProductDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-order";
        }
        orderService.createOrder(orderedProductDto.getProductName(), orderedProductDto.getProductQuantity());
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String showOrderList(Model model) {
        model.addAttribute("orderList", orderService.findOrdersWithProduct());
        return "orders";
    }

    @GetMapping("/remove/{id}")
    public String deleteById(@PathVariable String id, Model model) {
        int idForDeletion = Integer.parseInt(id);
        orderService.delete(idForDeletion);
        return "redirect:/orders";
    }
}
