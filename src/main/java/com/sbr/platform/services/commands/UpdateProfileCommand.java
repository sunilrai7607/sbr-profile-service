package com.sbr.platform.services.commands;

import com.sbr.platform.services.model.entity.Address;
import com.sbr.platform.services.model.entity.Contact;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateProfileCommand {

    private String userId;

    private Set<Address> addresses;

    private Set<Contact> contacts;

}