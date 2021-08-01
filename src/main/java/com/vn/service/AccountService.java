package com.vn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vn.entity.Account;

public interface AccountService {

	<S extends Account> List<S> findAll(Example<S> example, Sort sort);

	Account getById(String id);

	Account getOne(String id);

	void delete(Account entity);

	void deleteById(String id);

	long count();

	<S extends Account> boolean exists(Example<S> example);

	<S extends Account> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(String id);

	Optional<Account> findById(String id);

	List<Account> findAllById(Iterable<String> ids);

	List<Account> findAll(Sort sort);

	List<Account> findAll();

	Page<Account> findAll(Pageable pageable);

	<S extends Account> S save(S entity);

	List<Account> getAdministrators();

	

}
