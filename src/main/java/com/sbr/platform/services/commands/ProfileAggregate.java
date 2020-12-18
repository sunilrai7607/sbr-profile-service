package com.sbr.platform.services.commands;

import com.sbr.platform.services.events.EventProducer;
import com.sbr.platform.services.exception.InvalidRequestException;
import com.sbr.platform.services.mappers.CreateProfileMapper;
import com.sbr.platform.services.model.entity.Event;
import com.sbr.platform.services.model.entity.Profile;
import com.sbr.platform.services.repository.primary.ProfilePrimaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfileAggregate {

    private static final String PROFILE_CREATED_EVENT = "CreateProfileEvent";
    private static final String PROFILE_UPDATE_EVENT = "UpdateProfileEvent";
    private static final String PROFILE_DELETE_EVENT = "DeleteProfileEvent";
    private final EventProducer eventProducer;
    private final ProfilePrimaryRepository profilePrimaryRepository;
    private final CreateProfileMapper createProfileMapper;

    /**
     * Method to create the profile
     *
     * @param createProfileCommand
     * @return
     */
    public String handleCreateProfile(CreateProfileCommand createProfileCommand) {
        if (profilePrimaryRepository.existsByUserId(createProfileCommand.getUserId()))
            throw new InvalidRequestException();

        Profile profile = profilePrimaryRepository.save(createProfileMapper.convertUser(createProfileCommand));
        log.info("Profile has been created : {} ", profile.getId());
        boolean status = eventProducer.publishEvent(new Event(PROFILE_CREATED_EVENT, profile.getId()));
        log.info("{} : has been created and status : {} ", PROFILE_CREATED_EVENT, status);
        return profile.getId();
    }

    /**
     * Method to update the profile
     *
     * @param updateProfileCommand
     * @return
     */
    public String handleUpdateProfile(UpdateProfileCommand updateProfileCommand) {
        Profile profile = profilePrimaryRepository.findByUserId(updateProfileCommand.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Provided Resource Not found"));
        profile.setAddresses(updateProfileCommand.getAddresses());
        profile.setContacts(updateProfileCommand.getContacts());
        profile = profilePrimaryRepository.save(profile);
        log.info("Profile has been updated : {} ", profile.getId());
        boolean status = eventProducer.publishEvent(new Event(PROFILE_UPDATE_EVENT, profile.getId()));
        log.info("{} : has been created and status : {} ", PROFILE_UPDATE_EVENT, status);
        return profile.getId();
    }

    public boolean handleDeleteProfile(DeleteProfileCommand deleteProfileCommand) {
        if (profilePrimaryRepository.existsByUserId(deleteProfileCommand.getUserId())) {
            profilePrimaryRepository.deleteByUserId(deleteProfileCommand.getUserId());
            boolean status = eventProducer.publishEvent(new Event(PROFILE_DELETE_EVENT, deleteProfileCommand.getUserId()));
            log.info("{} : has been created and status : {} ", PROFILE_DELETE_EVENT, status);
        } else {
            throw new ResourceNotFoundException("Invalid resource Id");
        }
        return true;
    }

}
