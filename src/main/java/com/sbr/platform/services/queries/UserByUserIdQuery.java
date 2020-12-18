package com.sbr.platform.services.queries;

import com.sbr.platform.services.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserByUserIdQuery {

    private String userId;

    private String firstName;

    private String lastName;

    private Set<Address> addresses;

    public UserByUserIdQuery(String userId) {
        this.userId = userId;
    }
}
