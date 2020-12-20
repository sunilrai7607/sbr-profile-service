package com.sbr.platform.services.config;

import com.sbr.platform.services.model.entity.Profile;
import com.sbr.platform.services.model.enums.CarType;
import com.sbr.platform.services.model.enums.ProfileType;
import com.sbr.platform.services.repository.primary.ProfilePrimaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ProfileApplicationConfig implements CommandLineRunner {

    @Autowired
    private ProfilePrimaryRepository profilePrimaryRepository;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("Create Profile: {} ", profilePrimaryRepository.findAll());
        createDriver(midSizeCarDriver());
        createDriver(vanCarDriver());
        createDriver(economicCarDriver());
        createUser(createSampleUser());
    }

    private Profile createSampleUser() {
        Profile profile = new Profile();
        profile.setUserId("user-1");
        profile.setFirstName("Sunil");
        profile.setLastName("Rai");
        profile.setProfileType(ProfileType.USER);
        return profile;
    }

    private Profile economicCarDriver() {
        Profile profile = new Profile();
        profile.setUserId("driver-1");
        profile.setDriverId("xis-jam-1976");
        profile.setFirstName("James");
        profile.setLastName("John");
        profile.setCarType(CarType.ECONOMIC);
        return profile;
    }

    private Profile vanCarDriver() {
        Profile profile = new Profile();
        profile.setUserId("driver-2");
        profile.setDriverId("xis-mar-1876");
        profile.setFirstName("Marry");
        profile.setLastName("Jos");
        profile.setCarType(CarType.MIDSIZE);
        return profile;
    }

    private Profile midSizeCarDriver() {
        Profile profile = new Profile();
        profile.setUserId("driver-3");
        profile.setDriverId("xis-mad-1965");
        profile.setFirstName("Maddy");
        profile.setLastName("Casey");
        profile.setCarType(CarType.VAN);
        return profile;
    }

    private void createDriver(Profile profile) {
        if (!profilePrimaryRepository.existsByDriverId(profile.getDriverId())) {
            profilePrimaryRepository.save(profile);
        }
    }

    private void createUser(Profile profile) {
        if (!profilePrimaryRepository.existsByUserId(profile.getUserId())) {
            profilePrimaryRepository.save(profile);
        }
    }
}
