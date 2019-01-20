package com.invillia.acme.model.repo.store;

import com.invillia.acme.model.entity.Store;

public interface StoreCustomRepository  {

	Store findByName(String name);

}
