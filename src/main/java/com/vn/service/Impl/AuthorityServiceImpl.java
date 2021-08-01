package com.vn.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entity.Account;
import com.vn.entity.Authority;
import com.vn.repository.AccountRepository;
import com.vn.repository.AuthorityRepository;
import com.vn.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public <S extends Authority> S save(S entity) {
		return authorityRepository.save(entity);
	}

	@Override
	public List<Authority> findAll() {
		return authorityRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		authorityRepository.deleteById(id);
	}

	@Override
	public void delete(Authority entity) {
		authorityRepository.delete(entity);
	}

	@Override
	public List<Authority> findAuthoritiesOfAdministrator() {
		List<Account> accounts = accountRepository.getAdministrators();
		return authorityRepository.authoritiesOf(accounts);
	}

}
