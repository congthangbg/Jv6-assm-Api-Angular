package com.vn.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entity.Order;
import com.vn.repository.OrderRepository;
import com.vn.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
	
	
}
