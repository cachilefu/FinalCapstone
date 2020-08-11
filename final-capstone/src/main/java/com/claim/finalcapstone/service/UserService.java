package com.claim.finalcapstone.service;

import java.util.List;
import java.util.Optional;

import com.claim.finalcapstone.model.Users;



public interface UserService {
Optional<Users> findById(Long id);
	
	Optional<Users> findByEmail(String email);
	
	Optional<Users> login (String email, String password);
	
	List<Users> findByLastName(String lname);
	
	List<Users> findByName(String name);
	
	List<Users> findAll();
	
	void delete(Long id);
	
	void updateUser(Users user, Long id);
	
	void updateRole(String role, Long id);
	
	void resetPassword(String password, Long id);
	
	void save(Users user);
	

}
