package com.sbr.platform.services.config;

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
    }
}
