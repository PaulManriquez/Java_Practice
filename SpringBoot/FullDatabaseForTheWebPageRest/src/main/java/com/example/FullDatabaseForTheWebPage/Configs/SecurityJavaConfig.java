package com.example.FullDatabaseForTheWebPage.Configs;

import com.example.FullDatabaseForTheWebPage.Repository.RepositoryUsuariosPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig {

    @Autowired
    RepositoryUsuariosPerfil repositoryUsuariosPerfil;

    @Bean
    public PasswordEncoder passwordEncoder(){//Interface that returns the object that implements this interface
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
//        UserDetails user = User.withUsername("PaulM")
//                .password(encoder.encode("master22"))
//                .roles("ADMIN")
//                .build();

        List<UserDetails> allUsers = new ArrayList<>();
        //Get the users registered with his credentials
        List<UserProfileProjection> ListUsersAndPass = repositoryUsuariosPerfil.getUserProfiles();
        for(UserProfileProjection ptr:ListUsersAndPass){
            System.out.println(ptr.getPerfil() + " | " + ptr.getUsername() + " | " + ptr.getPassword());

            UserDetails user = User.withUsername(ptr.getUsername())
                    .password(encoder.encode(ptr.getPassword()))
                    .roles(ptr.getPerfil())
                    .build();

            allUsers.add(user);
        }

        return new InMemoryUserDetailsManager(allUsers);
    }

}
