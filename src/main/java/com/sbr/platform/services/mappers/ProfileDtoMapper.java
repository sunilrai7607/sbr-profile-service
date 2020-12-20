package com.sbr.platform.services.mappers;

import com.sbr.platform.services.model.dto.DriverProfileDTO;
import com.sbr.platform.services.model.dto.UserProfileDTO;
import com.sbr.platform.services.model.entity.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileDtoMapper {

    /**
     * Method to convert UserProfileDto
     *
     * @param profile
     * @return
     */
    UserProfileDTO convertUserDto(Profile profile);

    /**
     * Method to convert DriverProfileDto
     *
     * @param profile
     * @return
     */
    DriverProfileDTO convertDriverDto(Profile profile);

}
