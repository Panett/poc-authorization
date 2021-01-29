package com.github.robertomanfreda.poc.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO Add documentation over the project (using javadoc annotations)

@SpringBootApplication
public class POCAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(POCAuthorizationApplication.class, args);
    }
}
