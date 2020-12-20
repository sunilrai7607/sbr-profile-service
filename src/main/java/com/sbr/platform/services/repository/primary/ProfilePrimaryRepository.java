package com.sbr.platform.services.repository.primary;

import com.sbr.platform.services.model.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilePrimaryRepository extends MongoRepository<Profile, String> {

    Optional<Profile> findByUserId(final String userId);

    boolean existsByUserId(final String userId);

    boolean existsByDriverId(final String driverId);

    void deleteByUserId(final String userId);
}
