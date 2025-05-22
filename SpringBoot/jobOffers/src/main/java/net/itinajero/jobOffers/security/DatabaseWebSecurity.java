package net.itinajero.jobOffers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

//    @Bean
//    UserDetailsManager users(DataSource dataSource){
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        return users;
//    }

    @Bean
    public UserDetailsManager usersCustom(DataSource dataSource){
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        users.setUsersByUsernameQuery("select username,password,estatus from usuarios where username=?");//

                //Enable to this users permissions
                users.setAuthoritiesByUsernameQuery(
                        "select u.username, p.perfil from usuario_perfil up " +
                                "inner join usuarios u on u.id = up.idUsuario " +
                                "inner join perfiles p on p.id = up.idPerfil " +
                                "where u.username = ?"
                        );
        return users;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth //The users with this profiles have permissions

                                //The Static resources do not requiere authentication
                                .requestMatchers("/bootstrap/**","/imagenes/**","/tinymce/**","/logos/**").permitAll()

                        //The public views do not requiere authntication
//                                .requestMatchers("/","/login","/signup","/search","/vacantes/view/**").permitAll()
                                .requestMatchers("/","vacancies/indexPaginate").permitAll()
                        .requestMatchers("/vacancies/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
                        .requestMatchers("/categories/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
                        .requestMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
                        .anyRequest().authenticated()

                )
                .formLogin(withDefaults()); // or customize login

        return http.build();
    }

}
