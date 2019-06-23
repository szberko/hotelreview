//package com.szberko.hotelreview.configs;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableMBeanExport;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableGlobalAuthentication
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final CustomAuthenticationProvider customAuthenticationProvider;
//
//    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
//        this.customAuthenticationProvider = customAuthenticationProvider;
//    }
//
//    @Autowired
//    public void configAuthenticationProvider(AuthenticationManagerBuilder auth){
//        auth.authenticationProvider(customAuthenticationProvider);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http
//       .csrf().disable()
//            .authorizeRequests().anyRequest().authenticated()
//            .and().httpBasic()
//            .and().sessionManagement().disable();
//    }
//
//
//
//}
