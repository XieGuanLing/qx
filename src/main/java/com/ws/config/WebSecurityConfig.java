package com.ws.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by gl on 2018/1/27.
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void init(WebSecurity web) {
//        web.ignoring().antMatchers("/");
//    }


    /**
     * Override this method to configure {@link WebSecurity}. For example, if you wish to
     * ignore certain requests.
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/html/**");
    }


    /**
     * 覆盖默认配置
     *  http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.antMatcher("/**").authorizeRequests().anyRequest().authenticated()
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/html/inside/login.html")
                .loginProcessingUrl("/login")
                .and()
                .httpBasic();
    }
}