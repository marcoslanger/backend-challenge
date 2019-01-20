package com.invillia.acme.model.repo.store;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.model.entity.Store;

public interface StoreRepository extends CrudRepository<Store, Integer>, StoreCustomRepository {
	
	

}
