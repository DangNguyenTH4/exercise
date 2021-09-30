package com.exercise.publish.repository;

import com.exercise.publish.model.MessageHistory;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageHistoryRepository extends CouchbaseRepository<MessageHistory, String> {
}
