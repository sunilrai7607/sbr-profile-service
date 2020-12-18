package com.sbr.platform.services.service.impl;

import com.sbr.platform.services.commands.CreateProfileCommand;
import com.sbr.platform.services.commands.DeleteProfileCommand;
import com.sbr.platform.services.commands.ProfileAggregate;
import com.sbr.platform.services.mappers.ProfileCreateRequestMapper;
import com.sbr.platform.services.mappers.ProfileUpdateRequestMapper;
import com.sbr.platform.services.model.entity.Profile;
import com.sbr.platform.services.model.enums.ProfileType;
import com.sbr.platform.services.model.request.ProfileRequest;
import com.sbr.platform.services.queries.ProfileProjection;
import com.sbr.platform.services.queries.UserByUserIdQuery;
import com.sbr.platform.services.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileAggregate profileAggregate; //commands
    private final ProfileProjection profileProjection; //query
    private final ProfileCreateRequestMapper profileCreateRequestMapper;
    private final ProfileUpdateRequestMapper profileUpdateRequestMapper;

    /**
     * Method to find profile by id
     *
     * @param userId
     * @return
     */
    @Override
    public List<Profile> findProfileById(final String userId) {
        return Arrays.asList(profileProjection.handle(new UserByUserIdQuery(userId)));
    }

    @Override
    public String createProfile(ProfileRequest profileRequest) {
        CreateProfileCommand createProfileCommand = profileCreateRequestMapper.convertUser(profileRequest);
        createProfileCommand.setProfileType(ProfileType.USER);
        return profileAggregate.handleCreateProfile(createProfileCommand);
    }

    @Override
    public String updateProfile(ProfileRequest profileRequest) {
        return profileAggregate.handleUpdateProfile(profileUpdateRequestMapper.convertUser(profileRequest));
    }

    @Override
    public List<Profile> findAll() {
        return profileProjection.handle();
    }

    @Override
    public Boolean deleteById(final String userId) {
        return profileAggregate.handleDeleteProfile(new DeleteProfileCommand(userId));
    }
}
