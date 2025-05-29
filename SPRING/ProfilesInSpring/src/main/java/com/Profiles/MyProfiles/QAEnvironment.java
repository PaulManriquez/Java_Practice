package com.Profiles.MyProfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("QA")
public class QAEnvironment implements EnvironmentService{
    @Override
    public String getEnvironment() {
        return "QAEnvironment";
    }
}
