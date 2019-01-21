package com.invillia.acme.model.repo.store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.model.entity.Store;


@Repository
@Transactional(readOnly = true)
public class StoreCustomRepositoryImpl implements StoreCustomRepository {
	
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public Iterable<Store> findByName(String name) {
		Query query = entityManager.createNativeQuery("SELECT * FROM DB_ACME.STORE WHERE name LIKE ?", Store.class);
        query.setParameter(1, "%" + name + "%");
        return query.getResultList();
	}

}
