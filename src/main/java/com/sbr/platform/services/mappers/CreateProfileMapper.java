package com.sbr.platform.services.mappers;

import com.sbr.platform.services.commands.CreateProfileCommand;
import com.sbr.platform.services.model.entity.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateProfileMapper {

    Profile convertUser(CreateProfileCommand createProfileCommand);
}
