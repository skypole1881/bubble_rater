package com.bubble.application;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@ApplicationPath("/rest")
//@Configuration
public class RestApplication extends ResourceConfig{

    public RestApplication() {
        packages("com.bubble.ws");
    }
}