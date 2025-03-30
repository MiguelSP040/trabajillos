package utez.edu.mx.tasklistinterface.Task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permitir todas las rutas
                .allowedOrigins("*")  // Permitir el origen de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos HTTP permitidos
                .allowedHeaders("*")  // Permitir todos los headers
                .allowCredentials(false)  // Si usas credenciales, cámbialo a true
                .maxAge(3600);  // Cachear la respuesta por 1 hora
    }
}
