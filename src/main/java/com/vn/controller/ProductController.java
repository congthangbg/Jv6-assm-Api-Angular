package com.vn.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.entity.Product;
import com.vn.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService; 
	
	@GetMapping({"/product/list","/"})
	public String list(Model model,@RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items", list);
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		}
		return "product/list";
	}
	
	@GetMapping("/list")
	public String getAllList(Model model,@PathParam("key")String key) {
		
		if(!key.equals("")) {
			List<Product> list = productService.listSearch(key);
			model.addAttribute("items", list);
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		} 
		
		return "product/list";
	}
	

	@GetMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id")Integer id) {
		Optional<Product> item = productService.findById(id);
		model.addAttribute("item", item.get());
		return "product/detail";
	}
	

}
