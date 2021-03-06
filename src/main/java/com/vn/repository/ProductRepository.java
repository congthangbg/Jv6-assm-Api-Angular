package com.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.category.id = ?1")
	List<Product> findByCategoryId(String cid);
	
	@Query(value = "select * from Products where name like %:key%",nativeQuery = true)
	List<Product> listSearch(String key);
	
}
