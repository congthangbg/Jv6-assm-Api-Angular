package com.vn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vn.entity.Product;

public interface ProductService {

	Product getById(Integer id);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	<S extends Product> boolean exists(Example<S> example);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	boolean existsById(Integer id);

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	Optional<Product> findById(Integer id);

	List<Product> findAllById(Iterable<Integer> ids);

	List<Product> findAll();

	Page<Product> findAll(Pageable pageable);

	<S extends Product> S save(S entity);

	List<Product> findByCategoryId(String string);

	Product create(Product product);



}
