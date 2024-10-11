package pl.kf.itjobsearcher.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

@Configuration
public class WebConfiguration extends DelegatingWebMvcConfiguration {
    //TODO zdefiniowac dozwolone headery, doczytac o nich
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .maxAge(3600L)
                .allowedOrigins("*")
                .allowedHeaders("Content-Type", "Authorization","Origin", "Accept")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
