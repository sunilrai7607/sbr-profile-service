package com.sbr.platform.services.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    @Id
    private String id;

}
