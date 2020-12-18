package com.sbr.platform.services.service;

import com.sbr.platform.services.model.entity.Event;
import com.sbr.platform.services.repository.primary.EventPrimaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventPrimaryRepository eventPrimaryRepository;

    @Autowired
    public EventService(EventPrimaryRepository eventPrimaryRepository) {
        this.eventPrimaryRepository = eventPrimaryRepository;
    }


    public Event findById(final String userId) {
        return eventPrimaryRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Resource Not found"));
    }

    public List<Event> findAll() {
        return eventPrimaryRepository.findAll();
    }
}
