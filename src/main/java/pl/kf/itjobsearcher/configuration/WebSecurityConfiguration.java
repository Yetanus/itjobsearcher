package pl.kf.itjobsearcher.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    // 1. Configure two authentication methods (BasicAuth & JWT), both methods should work together
    // 2. BasicAuth should work for PATHS all actuator paths for path with matcher /customers/**
    // 3. BearerAuth (JWT) should work for all other paths
    // 4. In the application path with matcher "/offers/**" should not required any authentication
    // 5. Please create two users (technical and management user) for BasicAuthentication with roles

    // Component libraries: PrimeNG, Angular Material

    @Bean
    public SecurityFilterChain authenticationFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(http -> http.requestMatchers("/**").permitAll())
                .build();
    }
}
