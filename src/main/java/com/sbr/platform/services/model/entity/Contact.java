package com.sbr.platform.services.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Contact implements Serializable {

    private static final long serialVersionUID = 9161259519535285688L;
    private String type;
    private String detail;
}
