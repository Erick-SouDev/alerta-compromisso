package erick.br.configuration.views;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ConfigurationViews implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**", "/static/**", "/img/**", "js/**", "css/**" , "vendor/**" , "scss/**" )
				.addResourceLocations("classpath:/static/" , "classpath:/img/" , "classpath:/js/" , "classpath:/vendor/" , "classpath:/scss/");
	}
}
