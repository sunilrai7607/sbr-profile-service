package com.sbr.platform.services.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sbr.platform.services.model.entity.Address;
import com.sbr.platform.services.model.entity.Contact;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class UserProfileDTO implements BaseProfile {

    private String userId;

    private String firstName;

    private String lastName;

    private Set<Contact> contacts;

    private Set<Address> addresses;


}
