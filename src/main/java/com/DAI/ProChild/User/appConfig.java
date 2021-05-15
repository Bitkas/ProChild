package com.DAI.ProChild.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
//@EnableWebMvc
@ComponentScan(basePackageClasses = CustomAuthenticationProvider.class)
public class appConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private CustomAuthenticationProvider authenticationProvider;*/

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/complaint")
                //.hasAnyRole()
                .permitAll()


                .anyRequest()
                .authenticated().and()
                .formLogin()
                    //.loginPage("/login")
                    .defaultSuccessUrl("/EscolherArea.html")
                    .failureUrl("/login?error=true")
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(this.getAuthenticationProvider());
    }

    @Bean
    public CustomAuthenticationProvider getAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }
}
