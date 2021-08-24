package com.vn.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vn.entity.Account;
import com.vn.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {

	@Autowired
	AccountService accountService;
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccounts(@RequestParam("admin")Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return  ResponseEntity.ok(accountService.getAdministrators()) ;
		}
		return ResponseEntity.ok(accountService.findAll());
	}
}

