package com.invillia.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.entity.Store;
import com.invillia.acme.model.repo.store.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public Iterable<Store> findAll() {		
		return storeRepository.findAll();	
	}
	
	public Store findByName(String name) {		
		return storeRepository.findByName(name);	
	}
	
	public void save(Store s) {
		storeRepository.save(s);
	}

}
