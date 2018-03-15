package com.ws.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by gl on 2018/1/27.
 *
 *1. The username and password are obtained and combined into an instance of UsernamePasswordAuthenticationToken
 *  (an instance of the Authentication interface, which we saw earlier).
 *
 *2. The token is passed to an instance of AuthenticationManager for validation.
 *
 *3. The AuthenticationManager returns a fully populated Authentication instance on successful authentication.
 *
 *4. The security context is established by calling SecurityContextHolder.getContext().setAuthentication(…​),
 * passing in the returned authentication object.
 *
 */
public class AuthenticationExample {

    private static AuthenticationManager am = new SampleAuthenticationManager();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("Please enter your username:");
            String name = in.readLine();
            System.out.println("Please enter your password:");
            String password = in.readLine();
            try {
                //1.请求授权
                Authentication request = new UsernamePasswordAuthenticationToken(name, password);
                //2. 3.使用AuthenticationManager授权，且授权成功
                Authentication result = am.authenticate(request);
                //4. 和SecurityContextHolder建立关系
                SecurityContextHolder.getContext().setAuthentication(result);
                break;
            } catch(AuthenticationException e) {
                System.out.println("Authentication failed: " + e.getMessage());
            }
        }
        System.out.println("Successfully authenticated. Security context contains: " +
                SecurityContextHolder.getContext().getAuthentication());
    }
}

class SampleAuthenticationManager implements AuthenticationManager {
    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * 用户名称和凭证相同的获得授权
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.getName().equals(auth.getCredentials())) {
            return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }
}