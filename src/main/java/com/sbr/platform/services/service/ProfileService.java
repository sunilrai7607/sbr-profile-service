package com.sbr.platform.services.service;

import com.sbr.platform.services.model.dto.BaseProfile;
import com.sbr.platform.services.model.entity.Profile;
import com.sbr.platform.services.model.request.ProfileRequest;

import java.util.List;

public interface ProfileService {

    /**
     * Method to find profile by id
     *
     * @param userId
     * @return
     */
    List<Object> findProfileById(final String userId);

    String createProfile(final ProfileRequest profileRequest);

    String updateProfile(final ProfileRequest profileRequest);

    List<Profile> findAll();

    Boolean deleteById(final String userId);
}
