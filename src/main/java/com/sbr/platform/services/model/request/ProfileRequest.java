package com.sbr.platform.services.model.request;

import com.sbr.platform.services.model.entity.Address;
import com.sbr.platform.services.model.entity.Contact;
import lombok.Data;

import java.util.Set;

@Data
public class ProfileRequest {

    private String userId;

    private String firstName;

    private String lastName;

    private Set<Address> addresses;

    private Set<Contact> contacts;
}
