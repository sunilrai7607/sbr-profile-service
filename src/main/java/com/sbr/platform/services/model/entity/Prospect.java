package com.sbr.platform.services.model.entity;

import com.sbr.platform.services.model.dto.BaseProfile;
import lombok.Data;

@Data
public class Prospect implements BaseProfile {

    private String firstName;

    private String lastName;
}
