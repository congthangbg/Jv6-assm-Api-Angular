package com.vn.service;

import java.util.Optional;

import com.vn.entity.Order;

public interface OrderDetailService {

	Optional<Order> findById(Long id);

}
