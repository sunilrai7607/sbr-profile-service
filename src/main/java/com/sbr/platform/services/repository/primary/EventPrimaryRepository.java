package com.sbr.platform.services.repository.primary;

import com.sbr.platform.services.model.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventPrimaryRepository extends MongoRepository<Event, String> {

    Optional<Event> findByUserId(final String userId);
}
