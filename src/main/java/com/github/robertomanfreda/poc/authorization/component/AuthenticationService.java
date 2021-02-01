package com.github.robertomanfreda.poc.authorization.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     *<p> It will throw a UsernameNotFoundException if the usermame does not exists </p>
     *
     * @param base64Token   the plain user password
     * @return              true if the username and password are correct, false if it's not or the user does not exists
     */
    public boolean authenticate(String base64Token) {
        String[] decodedToken = new String(Base64.getDecoder().decode(base64Token)).split(":");
        String username = decodedToken[0];
        String password = decodedToken[1];
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(passwordEncoder.matches(password, userDetails.getPassword()))
                return true;
        } catch (UsernameNotFoundException e) {
            log.error("Username \"{}\" not found", username);
        }
        return false;
    }

}
