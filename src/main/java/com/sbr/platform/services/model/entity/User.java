package com.sbr.platform.services.model.entity;

import com.sbr.platform.services.model.dto.BaseProfile;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Set;

@Data
public class User implements BaseProfile {

    private String userid;

    private String firstName;

    private String lastName;

    private Set<Contact> contacts;

    private Set<Address> addresses;

    @Field
    @Indexed(name = "expiredAt-user-indexed", expireAfterSeconds = 10)
    private Date expireAt = new Date();
}
