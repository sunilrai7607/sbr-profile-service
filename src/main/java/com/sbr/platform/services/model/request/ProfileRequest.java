package com.sbr.platform.services.model.request;

import com.sbr.platform.services.model.entity.Address;
import com.sbr.platform.services.model.entity.Contact;
import com.sbr.platform.services.model.enums.CarType;
import com.sbr.platform.services.model.enums.ProfileType;
import lombok.Data;

import java.util.Set;

@Data
public class ProfileRequest {

    private ProfileType profileType;

    private String userId;

    private String firstName;

    private String lastName;

    private Set<Address> addresses;

    private Set<Contact> contacts;

    private String driverId;

    private CarType carType;
}
