package com.sbr.platform.services.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    @Id
    private String id;

    private Date createdAt = new Date();

//    @Field
//    @Indexed(name = "expiredAt-indexed", expireAfter = "${sbr.mongodb.config.retention-time}")
//    private Date expireAt = new Date();

}
