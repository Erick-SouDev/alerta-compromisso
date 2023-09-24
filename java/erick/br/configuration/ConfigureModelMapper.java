package erick.br.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureModelMapper {

	
	 
	   /*typeMap.addMapping(Src::getA, Dest::setB);
	   typeMap.<String>addMapping(src -> src.getC().getD(), (dest, value) -> dest.getE().setF(value))*/
	 

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
