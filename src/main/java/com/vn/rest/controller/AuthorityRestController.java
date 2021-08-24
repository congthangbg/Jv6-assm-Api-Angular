package com.vn.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Authority>> findAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			List<Authority> list= authorityService.findAuthoritiesOfAdministrator();
			for (Authority authority : list) {
				System.out.println(authority.getAccount().getFullname());
			}
			return ResponseEntity.ok(authorityService.findAuthoritiesOfAdministrator());
		}
		return ResponseEntity.ok(authorityService.findAll());
	}
	

	@PostMapping("save")
	public ResponseEntity<Authority> post(@RequestBody Authority auth) {
		if(auth != null ) {
			return ResponseEntity.ok(authorityService.save(auth));
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		if(id != null) {
			authorityService.deleteById(id);
		}else {
			throw new RuntimeException();
		}
	}
	
	
}





