package com.java.workshopmongo.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.workshopmongo.document.LiveDocument;

@Repository
public interface LiveRepository extends MongoRepository<LiveDocument, String> {

    public Page<LiveDocument> findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime date, Pageable pageable);
    public Page<LiveDocument> findByLiveDateBeforeOrderByLiveDateDesc(LocalDateTime date, Pageable pageable);
}
