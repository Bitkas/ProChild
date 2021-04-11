package com.DAI.ProChild;

import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;


public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    public void customize(ConfigurableServletWebServerFactory factory) {
        System.out.println(System.getenv("PORT"));
        if(System.getenv("PORT") != null) {
            factory.setPort(Integer.valueOf(System.getenv("PORT")));
        }
    }
}
