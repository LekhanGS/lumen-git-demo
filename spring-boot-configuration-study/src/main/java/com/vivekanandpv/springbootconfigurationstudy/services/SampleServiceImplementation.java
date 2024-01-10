package com.vivekanandpv.springbootconfigurationstudy.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImplementation implements SampleService {
    private final String message;

    //  we can create different environments as staging, uat, test, preprod, etc
    //  every environment has its own application-<env>.properties
    //  to set the current environment, pass the environment variable: SPRING_PROFILES_ACTIVE
    //  In the absense of such an environment variable, application.properties will be considered

    public SampleServiceImplementation(@Value("${app.message}") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
