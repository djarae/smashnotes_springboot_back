package smashnotest_back.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * NOTA: Esta configuración CORS está DESHABILITADA porque Spring Security
 * ahora maneja CORS en SecurityConfig.java (auth/config/SecurityConfig.java).
 * 
 * Si no usas Spring Security, puedes descomentar esta clase.
 * 
 * @deprecated Usar SecurityConfig.corsConfigurationSource() en su lugar
 */
// @Configuration
// @EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    }
}
