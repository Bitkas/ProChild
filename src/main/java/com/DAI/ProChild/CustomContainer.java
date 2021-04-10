package com.DAI.ProChild;

import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

import static sun.management.snmp.AdaptorBootstrap.DefaultValues.PORT;

public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    public void customize(ConfigurableServletWebServerFactory factory) {
        if(System.getenv(PORT) != null) {
            factory.setPort(Integer.valueOf(System.getenv(PORT)));
        }
    }
}
