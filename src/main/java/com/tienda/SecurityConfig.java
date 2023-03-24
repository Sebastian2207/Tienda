package com.tienda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author sebas
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Se definen los usuarios del sistema en formato de memoria
    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username("sebas")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        
        UserDetails vendedor = User.builder()
                .username("rebeca")
                .password("{noop}456")
                .roles("USER", "VENDEDOR")
                .build();
        
        UserDetails cliente = User.builder()
                .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(cliente, vendedor, admin);
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        //Permisos index para todos (sin iniciar sesion)
                        .requestMatchers("/", 
                                "index",
                                "/errores/**",
                                "/webjars/**").permitAll()
                        
                        //Permisos solo para los administradores
                        .requestMatchers("/articulo/nuevo", "/articulo/guardar",
                                "/articulo/modificar/**",
                                "/articulo/eliminar/**").hasRole("ADMIN")
                );
        
        return http.build();
    }
}
