package com.patrycjamecina.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String contentManager = "CONTENT_MANAGER";
    private static final String customer = "CUSTOMER";

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET).hasRole(customer)
                .antMatchers(HttpMethod.POST, "/order/prepare").hasRole(customer)
                .antMatchers(HttpMethod.POST).hasRole(contentManager)
                .antMatchers(HttpMethod.PUT).hasRole(contentManager)
                .antMatchers(HttpMethod.DELETE).hasRole(contentManager)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user")).roles(customer)
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles(customer, contentManager);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}