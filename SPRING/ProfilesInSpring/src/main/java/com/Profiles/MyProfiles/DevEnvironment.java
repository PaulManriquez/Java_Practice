package com.Profiles.MyProfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"DEV","default"})//In case this is not set in the application.properties
//By default we get a DEV Profile
public class DevEnvironment implements EnvironmentService{

    @Override
    public String getEnvironment() {
        return "DevEnvironment";
    }
}
