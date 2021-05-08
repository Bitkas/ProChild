package com.DAI.ProChild.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MainWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("com.Prochild");

        servletContext.addListener(new ContextLoaderListener(root));
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/login");
        servletRegistration.addMapping("/complaint");
    }
}
