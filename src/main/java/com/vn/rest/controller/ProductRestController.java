package com.vn.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.entity.OrderDetail;
import com.vn.entity.Product;
import com.vn.service.OrderDetailService;
import com.vn.service.OrderService;
import com.vn.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping()
	public ResponseEntity<List<Product>> getAll() {
		try {
			return ResponseEntity.ok(productService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getOne(@PathVariable("id") Integer id) {
		if(id != null) {
			return ResponseEntity.ok(productService.findById(id));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Product product) {
		if(product != null) {
			return ResponseEntity.ok(productService.save(product));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody Product product) {
		System.out.println("id :"+id);
		System.out.println("Product" + product.getId() + "----"+ product.getName());
		if(product != null) {
			return ResponseEntity.ok(productService.save(product));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 productService.deleteById(id);
	}
	
	
	
}
