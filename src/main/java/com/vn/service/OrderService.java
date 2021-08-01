package com.vn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.databind.JsonNode;
import com.vn.entity.Order;
import com.vn.repository.OrderDetailRepository;

public interface OrderService {

	Order create(JsonNode orderDate);

	Order getById(Long id);

	void delete(Order entity);

	void deleteById(Long id);

	boolean existsById(Long id);

	Order findById(Long id);

	List<Order> findAll();

	Page<Order> findAll(Pageable pageable);

	List<Order> findByUsername(String username);



}
