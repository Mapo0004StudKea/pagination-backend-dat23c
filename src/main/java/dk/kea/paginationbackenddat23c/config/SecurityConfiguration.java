package dk.kea.paginationbackenddat23c.config;

import dk.kea.paginationbackenddat23c.JwtAuthenticationEntryPoint;
import dk.kea.paginationbackenddat23c.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    private JwtFilter filter;
    private static PasswordEncoder passwordEncoder;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        if(passwordEncoder==null){
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("WebSec configure(HttpSecurity) Call: 2");
        http.cors().and().csrf().disable()  // was cors().and() after http
                // to implement CSRF token https://www.javainuse.com/spring/boot_security_csrf
                // "antMathcers" comes from Apache Ant build system.
                // Since Spring 3, the next line replaces the old one:
                // .authorizeRequests().antMatchers("/login", "/signup").permitAll()
        .authorizeHttpRequests().requestMatchers("/login", "/signup").permitAll()
        .anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("addCorsMappings called");
        registry.addMapping("/**")  // /** means match any string recursively
                .allowedOriginPatterns("http://localhost:*") //Multiple strings allowed. Wildcard * matches all port numbers.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // decide which methods to allow
                .allowCredentials(true);
    }
    // hvis man skal køre på en virtuel maskine skal .allowedOriginPatterns("http://localhost:*")
    // ændres til "http://*:*"
    // med certifikat skal det være "https://*:*"
    // certifikat køre på port 443, 80
}
