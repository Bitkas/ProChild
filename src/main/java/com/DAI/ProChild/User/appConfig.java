package com.DAI.ProChild.User;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
//@EnableWebMvc
//@ComponentScan(basePackageClasses = CustomAuthenticationProvider.class)
public class appConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private CustomAuthenticationProvider authenticationProvider;*/

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/complaint", "/RegisterUser/", "CriarConta.html", "/CriarConta")
                //.hasAnyRole()
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin()
                    //.loginPage("/login")
                    .defaultSuccessUrl("/Duvidas")
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
