package com.java.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.workshopmongo.document.LiveDocument;

@Repository
public interface LiveRepository extends MongoRepository<LiveDocument, String> {

    
}
