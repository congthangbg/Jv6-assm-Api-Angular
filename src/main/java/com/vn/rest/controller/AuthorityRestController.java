package com.vn.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.entity.Authority;
import com.vn.service.AuthorityService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {

	@Autowired
	AuthorityService authorityService;
	
	@GetMapping("/list")
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			List<Authority> list= authorityService.findAuthoritiesOfAdministrator();
			for (Authority authority : list) {
				System.out.println(authority.getAccount().getFullname());
			}
			return authorityService.findAuthoritiesOfAdministrator();
		}
		return authorityService.findAll();
	}
	

	@PostMapping("save")
	public Authority post(@RequestBody Authority auth) {
		return authorityService.save(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.deleteById(id);
	}
	
	
}





