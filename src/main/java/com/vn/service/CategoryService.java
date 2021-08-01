package com.vn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vn.entity.Category;

public interface CategoryService {

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	Category getById(String id);

	Category getOne(String id);

	void delete(Category entity);

	void deleteById(String id);

	long count();

	<S extends Category> boolean exists(Example<S> example);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(String id);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	Optional<Category> findById(String id);

	List<Category> findAllById(Iterable<String> ids);

	List<Category> findAll(Sort sort);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	<S extends Category> S save(S entity);

}
