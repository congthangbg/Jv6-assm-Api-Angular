package com.vn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.vn.entity.Order;
import com.vn.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	
	@Autowired
	OrderService orderService;;
	
	@PostMapping()
	public ResponseEntity<Order> create(@RequestBody JsonNode orderDate) {
		if(orderDate != null) {
			return ResponseEntity.ok(orderService.create(orderDate));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
