package com.claim.finalcapstone.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.finalcapstone.model.Show;
import com.claim.finalcapstone.repository.ShowRepository;

@Service
@Transactional
public class ShowService {
	
	@Autowired ShowRepository showRepository;
	
	public void save(Show show) {
		showRepository.save(show);
	}
	
	public List<Show> listAll() {
		return(List<Show>) showRepository.findAll();
	}
	
	public Show get(Long id) {
		return showRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		showRepository.deleteById(id);
	}
	public List<Show> search(String keyword) {
		return showRepository.search(keyword);
	}
	
	
	}


