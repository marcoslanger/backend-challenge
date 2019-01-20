package com.invillia.acme.model.repo;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.model.entity.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {

}
