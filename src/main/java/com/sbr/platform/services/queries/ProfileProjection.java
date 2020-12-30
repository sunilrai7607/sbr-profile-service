package com.sbr.platform.services.queries;

import com.sbr.platform.services.mappers.ProfileDtoMapper;
import com.sbr.platform.services.model.dto.BaseProfile;
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
    private final ProfileDtoMapper profileDtoMapper;

    public BaseProfile handle(UserByUserIdQuery userByUserIdQuery) {
        Profile profile = profilePrimaryRepository.findByUserId(userByUserIdQuery.getUserId()).orElseThrow(() -> new RuntimeException("Resource not found"));
        log.info("Queries Profile: {} ", profile);
        BaseProfile baseProfile;
        switch (profile.getProfileType()) {
            case USER:
                baseProfile = profileDtoMapper.convertUserDto(profile);
                break;

            case DRIVER:
                baseProfile = profileDtoMapper.convertDriverDto(profile);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + profile.getProfileType());
        }

        return baseProfile;

    }

    public List<Profile> handle() {
        log.info("Pulling from DB");
        return profilePrimaryRepository.findAll();
    }

}
