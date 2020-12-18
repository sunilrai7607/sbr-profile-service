package com.sbr.platform.services.commands;

import com.sbr.platform.services.model.enums.ProfileType;
import lombok.Data;

@Data
public class CreateProfileCommand {

    private ProfileType profileType;

    private String userId;

    private String firstName;

    private String lastName;
}
