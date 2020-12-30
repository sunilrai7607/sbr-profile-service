package com.sbr.platform.services.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sbr.platform.services.model.BaseEntity;
import com.sbr.platform.services.model.enums.CarType;
import com.sbr.platform.services.model.enums.ProfileType;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Data
@Document(collection = "PROFILES")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class Profile extends BaseEntity {

    private ProfileType profileType;

    @Indexed(name = "userId", unique = true, sparse = true)
    private String userId;

    private String firstName;

    private String lastName;

    private Set<Address> addresses;

    private Set<Contact> contacts;

    private String driverId;

    private CarType carType;

    @Indexed(name = "expiredAt-profile-indexed", expireAfterSeconds = 10)
    private Date expireAt = new Date();

}
