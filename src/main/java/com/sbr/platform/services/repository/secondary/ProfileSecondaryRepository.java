package com.sbr.platform.services.repository.secondary;

import com.sbr.platform.services.model.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileSecondaryRepository extends MongoRepository<Profile, String> {
}
