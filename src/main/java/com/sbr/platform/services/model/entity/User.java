package com.sbr.platform.services.model.entity;

import com.sbr.platform.services.model.dto.BaseProfile;
import lombok.Data;

import java.util.Set;

@Data
public class User implements BaseProfile {

    private String userid;

    private String firstName;

    private String lastName;

    private Set<Contact> contacts;

    private Set<Address> addresses;
}
