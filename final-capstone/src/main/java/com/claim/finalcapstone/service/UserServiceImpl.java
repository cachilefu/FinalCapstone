package com.claim.finalcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.finalcapstone.model.Users;
import com.claim.finalcapstone.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<Users> findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findEmail(email);
	}

	@Override
	public List<Users> findByLastName(String lname) {
		// TODO Auto-generated method stub
		return userRepository.findByLastName(lname);
	}

	@Override
	public Optional<Users> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Optional<Users> login(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.login(email, password);
	}

	@Override
	public List<Users> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void updateUser(Users user, Long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).ifPresent(a->{
			a.setFname(user.getFname());
			a.setLname(user.getLname());
			}
		);
	}

	@Override
	public void updateRole(String role, Long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).ifPresent(a->{
			a.setRole(role);
		});
	}

	@Override
	public void resetPassword(String password, Long id) {
		userRepository.findById(id).ifPresent(a->{
			a.setPassword(password);
		});
		
	}

	@Override
	public void save(Users user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

}
