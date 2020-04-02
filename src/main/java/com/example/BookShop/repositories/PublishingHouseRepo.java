package com.example.BookShop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepo extends MongoRepository<PublishingHouseRepo,String> {
}
