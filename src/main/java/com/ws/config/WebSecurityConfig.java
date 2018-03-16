package com.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by gl on 2018/1/27.
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void init(WebSecurity web) {
//        web.ignoring().antMatchers("/");
//    }


//    /**
//     * Override this method to configure {@link WebSecurity}. For example, if you wish to
//     * ignore certain requests.
//     */
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/html/**");
//    }


    /**
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //默认配置
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
        //使用新配置
        //http.antMatcher("/**").authorizeRequests().anyRequest().authenticated()
    }


    /**
     * 参见WebSecurityConfigurerAdapter的文档， 下面注入的UserDetailsService是必须的，
     * 不然AuthenticationManagerConfiguration还会生成默认的密码
     * @return
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}