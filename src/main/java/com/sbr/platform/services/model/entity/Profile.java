package com.sbr.platform.services.model.entity;

import com.sbr.platform.services.model.BaseEntity;
import com.sbr.platform.services.model.enums.ProfileType;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "PROFILES")
public class Profile extends BaseEntity {

    private ProfileType profileType;

    @Indexed(name = "userId", unique = true, sparse = true)
    private String userId;

    private String firstName;

    private String lastName;

    private Set<Address> addresses;

    private Set<Contact> contacts;

}
