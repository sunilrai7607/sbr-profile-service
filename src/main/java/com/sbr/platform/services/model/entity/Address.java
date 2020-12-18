package com.sbr.platform.services.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private String city;
    private String state;
    private String postcode;
}
