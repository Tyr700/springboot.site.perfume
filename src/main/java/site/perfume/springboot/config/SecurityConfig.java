package site.perfume.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for REST API simplicity
            .csrf(AbstractHttpConfigurer::disable)
            
            // Configure authorization rules
            .authorizeHttpRequests(authorize -> authorize
                // Allow unrestricted access to static resources
                .requestMatchers("/", "/html/**", "/css/**", "/js/**", "/imgs/**", "/*.html", "/**/*.html").permitAll()
                // Allow unrestricted access to public API endpoints
                .requestMatchers("/usuarios/login", "/usuarios/").permitAll()
                // Secure everything else by default
                .anyRequest().authenticated()
            )
            
            // Disable form login redirect
            .formLogin(AbstractHttpConfigurer::disable)
            
            // Disable HTTP Basic authentication popup
            .httpBasic(AbstractHttpConfigurer::disable);
            
        return http.build();
    }
}

