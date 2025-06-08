package com.Main.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig {

    //Password encoder manager
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Configure the application
    @Bean                                          //Injecting bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){

        UserDetails user = User.withUsername("PaulM")
                .password(encoder.encode("master22"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("JohnD")
                .password(encoder.encode("password123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user,user2);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        //.loginPage("/login")  // Custom login page URL (optional)
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/roles/**").permitAll()
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll          // Allow everyone to access the login page
                        //.defaultSuccessUrl("/home", true) // Redirect after successful login
                        //.failureUrl("/login?error=true")  // Custom failure URL (optional)
                );

        return http.build();
    }

}
//================================== INTERFACE (Above all)
//public interface PasswordEncoder {
//    String encode(CharSequence rawPassword);
//    boolean matches(CharSequence rawPassword, String encodedPassword);
//}
//================================== CLASS that inplements this
//public class BCryptPasswordEncoder implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence rawPassword) {
//        // bcrypt hashing logic here
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        // bcrypt verification logic here
//    }
//}

