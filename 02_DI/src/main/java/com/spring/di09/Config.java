package com.spring.di09;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public PCspec2 ramInfo() {
		ArrayList<String> raminfo =
				new ArrayList<String>();
		return raminfo;
	}
}
