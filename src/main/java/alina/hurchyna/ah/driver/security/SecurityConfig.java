package alina.hurchyna.ah.driver.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public interface SecurityConfig extends WebSecurityConfigurer {
    void configure(HttpSecurity http) throws Exception;
}

