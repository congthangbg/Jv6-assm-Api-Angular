package com.vn.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vn.entity.Order;
import com.vn.entity.OrderDetail;
import com.vn.repository.OrderDetailRepository;
import com.vn.repository.OrderRepository;
import com.vn.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{


	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

	
	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public Order getById(Long id) {
		return orderRepository.getById(id);
	}


	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		 Order order = mapper.convertValue(orderData, Order.class);
		 orderRepository.save(order);
		 
		 TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};

		 List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				 .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		 orderDetailRepository.saveAll(details);
		 
		 return order;
	}

	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return orderRepository.findByUsername(username);
	}

	

	
}
