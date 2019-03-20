package com.nagarro.HRManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.HRManagement.dlo.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Integer> {
	List<UserDetails> findUserDetailsByusername(String username);
}
