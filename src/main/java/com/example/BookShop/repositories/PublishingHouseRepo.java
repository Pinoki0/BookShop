package com.example.BookShop.repositories;

import com.example.BookShop.models.PublishingHouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepo extends MongoRepository<PublishingHouse, String> {
}
