package com.vn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.entity.Role;
import com.vn.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;
	
	
	@GetMapping
	public List<Role> getAll(){
		List<Role> list = roleService.findAll();
		return list;
	}
	
}

