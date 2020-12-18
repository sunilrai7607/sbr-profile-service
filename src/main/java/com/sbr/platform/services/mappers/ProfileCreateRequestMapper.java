package com.sbr.platform.services.mappers;

import com.sbr.platform.services.commands.CreateProfileCommand;
import com.sbr.platform.services.model.request.ProfileRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileCreateRequestMapper {

    CreateProfileCommand convertUser(ProfileRequest profileRequest);
}
