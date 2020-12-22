package com.sbr.platform.services.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sbr.platform.services.model.enums.CarType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverProfileDTO implements BaseProfile {

    private String driverId;

    private String firstName;

    private String lastName;

    private CarType carType;

}
