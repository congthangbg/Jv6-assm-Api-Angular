package com.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	@Query("select distinct ar.account from Authority ar where ar.role.id in ('DIRE','STAF')")
	List<Account> getAdministrators();
}


