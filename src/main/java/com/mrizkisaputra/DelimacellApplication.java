package com.mrizkisaputra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:/database.properties")
})
public class DelimacellApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelimacellApplication.class, args);
	}

}
