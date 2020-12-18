package com.sbr.platform.services.model.entity;

import com.sbr.platform.services.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "EVENTS")
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity {

    private static final long serialVersionUID = 5207324520134194041L;

    private Date created = new Date();
    private String userId;
    private String eventName;

    public Event(String eventName, String userId) {
        this.eventName = eventName;
        this.userId = userId;
        setId(UUID.randomUUID().toString());
    }
}
