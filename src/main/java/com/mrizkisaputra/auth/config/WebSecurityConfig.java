package com.mrizkisaputra.auth.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Objects;

import static com.mrizkisaputra.auth.query.ApplicationUserQuery.SQL_LOGIN;
import static com.mrizkisaputra.auth.query.ApplicationUserQuery.SQL_PERMISSION;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(auth -> {
            auth.anyRequest().fullyAuthenticated();
        }).formLogin(configurer -> {
            configurer.loginPage("/login").permitAll();
            configurer.defaultSuccessUrl("/home", true);
        }).logout(configurer -> {
            configurer.logoutUrl("/logout");
            configurer.clearAuthentication(true);
            configurer.invalidateHttpSession(true);
            configurer.logoutSuccessUrl("/login");
            configurer.deleteCookies("JSESSIONID");
        });
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(HikariDataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery(SQL_LOGIN.getQuery());
        manager.setAuthoritiesByUsernameQuery(SQL_PERMISSION.getQuery());
        return manager;
    }

}
