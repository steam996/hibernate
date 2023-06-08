package ru.netology.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().permitAll()
                .and()
                .authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/person/by-name-surname").authenticated()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("write")
                .and()
                .authorizeRequests().antMatchers("/persons").hasAuthority("all")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder().encode("pswd"))
                .authorities("read")
                .and()
                .withUser("moder")
                .password(encoder().encode("pswd"))
                .authorities("read", "write")
                .and()
                .withUser("admin")
                .password(encoder().encode("pwd"))
                .authorities("read", "write", "all");
    }

}
