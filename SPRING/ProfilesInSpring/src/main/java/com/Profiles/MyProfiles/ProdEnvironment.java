package com.Profiles.MyProfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("PROD")
public class ProdEnvironment implements EnvironmentService{
    @Override
    public String getEnvironment() {
        return "ProdEnvironment";
    }
}
