package com.sbr.platform.services.mappers;

import com.sbr.platform.services.commands.UpdateProfileCommand;
import com.sbr.platform.services.model.request.ProfileRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileUpdateRequestMapper {

    UpdateProfileCommand convertUser(ProfileRequest profileRequest);
}
