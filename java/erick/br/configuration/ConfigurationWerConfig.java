package erick.br.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import erick.br.configuration.security.InterceptorRequest;

@Configuration
public class ConfigurationWerConfig    implements  WebMvcConfigurer {


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**" ).addResourceLocations("/resources/" )
		.resourceChain(true);
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new  InterceptorRequest())
		.addPathPatterns("/views/" ,"/**");
		
		
	}
}
