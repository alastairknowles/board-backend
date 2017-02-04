package com.prism.hr.board;

import com.stormpath.spring.config.StormpathWebSecurityConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@SpringBootApplication
public class Application extends WebSecurityConfigurerAdapter {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.apply(StormpathWebSecurityConfigurer.stormpath())
                .and().authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/api/**").fullyAuthenticated();
    }
    
}
