package com.jumbo.api.repository;

import com.jumbo.api.model.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {

}
