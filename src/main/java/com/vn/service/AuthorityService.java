package com.vn.service;

import java.util.List;

import com.vn.entity.Account;
import com.vn.entity.Authority;

public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdministrator();

	void delete(Authority entity);

	void deleteById(Integer id);

	List<Authority> findAll();

	<S extends Authority> S save(S entity);

	

}
