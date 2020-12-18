package com.sbr.platform.services.queries;

import com.sbr.platform.services.model.entity.Profile;
import com.sbr.platform.services.repository.primary.ProfilePrimaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfileProjection {

    private final ProfilePrimaryRepository profilePrimaryRepository;

    public Profile handle(UserByUserIdQuery userByUserIdQuery) {
        return profilePrimaryRepository.findByUserId(userByUserIdQuery.getUserId()).orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    public List<Profile> handle() {
        return profilePrimaryRepository.findAll();
    }

}
