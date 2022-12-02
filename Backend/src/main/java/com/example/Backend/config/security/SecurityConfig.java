package com.example.Backend.config.security;

import com.example.Backend.config.jwt.JwtEntryPointConfig;
import com.example.Backend.config.jwt.JwtTokenFilterConfig;
import com.example.Backend.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtEntryPointConfig jwtEntryPointConfig;

    /**
     * Registro de propiedades a implementar
     */
    @Bean
    public JwtTokenFilterConfig jwtTokenFilter() {
        return new JwtTokenFilterConfig();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Registro de los endpoints, definiendo quien tiene acceso a cada uno de ellos, esto con el fin de darle
     * seguridad a nuestra aplicación
     */

    @Primary
    @Bean
    protected HttpSecurity configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/**", "/usuario/**").permitAll()
                .antMatchers(HttpMethod.GET, "/producto/**", "/caracteristica/**"
                        , "/categoria/**", "/ciudad/**", "/imagen/**").permitAll()
                .antMatchers(HttpMethod.POST, "/producto/**", "/caracteristica/**"
                        , "/categoria/**", "/ciudad/**", "/imagen/**", "/reserva/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/producto/**", "/caracteristica/**"
                        , "/categoria/**", "/ciudad/**", "/imagen/**", "/reserva/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/producto/**", "/caracteristica/**"
                        , "/categoria/**", "/ciudad/**", "/imagen/**", "/reserva/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/reserva/**").hasAnyRole("USER")
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPointConfig)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http;
    }

    /**
     * Se registran los cors origin para que el ecosistema permita el libre consumo de los endpoints desde
     * el front
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }

    /**
     * Registro los filtros configurados anteriormente para que sea un filter implementado por sprinb
     * de esta manera uso e implemento el registro y apertura de los cors
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
