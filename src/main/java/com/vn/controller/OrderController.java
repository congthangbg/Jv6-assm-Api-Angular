	package com.vn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vn.entity.Order;
import com.vn.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/order/checkout")
	public String view() {
		return "order/checkout";
	}
	
	@GetMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}
	
	@GetMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id,Model model) {
		Order order = orderService.findById(id);
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
	
}
