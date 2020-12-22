package com.sbr.platform.services.controller;

import com.sbr.platform.services.model.dto.BaseProfile;
import com.sbr.platform.services.model.entity.Profile;
import com.sbr.platform.services.model.request.ProfileRequest;
import com.sbr.platform.services.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomProfileController {

    private final ProfileService profileService;

    @Autowired
    public CustomProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Object>> findProfile(@PathVariable("userId") final String userId) {
        return ResponseEntity.ok(profileService.findProfileById(userId));
    }

    @GetMapping
    public ResponseEntity<List<Profile>> findAll() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProfile(@RequestBody ProfileRequest profileRequest) {
        return ResponseEntity.ok(profileService.createProfile(profileRequest));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProfile(@RequestBody ProfileRequest profileRequest) {
        return ResponseEntity.ok(profileService.updateProfile(profileRequest));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> updateProfile(@PathVariable("userId") final String userId) {
        return ResponseEntity.ok(profileService.deleteById(userId));
    }

}
