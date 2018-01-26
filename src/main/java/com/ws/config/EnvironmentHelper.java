package com.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class EnvironmentHelper {

    @Autowired
    private Environment environment;

    public boolean isProductionEnvironment() {
        for (String profile : environment.getActiveProfiles()) {
            if (profile.equals("prod"))
                return true;
        }
        return false;
    }

    public String currentEnvironment() {
        for (String profile : environment.getActiveProfiles()) {
            switch (profile){
                case "prod":
                    return "prod";
                case "prod-pre":
                    return "prod-pre";
                case "prod-test":
                    return "prod-test";
                case "dev":
                    return "dev";
                case "local":
                    return "local";
            }
        }

        return "";
    }
}
