package com.wind.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .authorizeRequests().antMatchers("/h2/**", "/wechat/portal", "/static/**", "/druid/**").permitAll()
                .antMatchers("/swagger**", "/swagger-resources/**", "/webjars/**", "/v2/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
