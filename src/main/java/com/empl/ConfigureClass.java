package com.empl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureClass {
	@Bean
	public ModelMapper model() {
		return new ModelMapper();
	}

}

