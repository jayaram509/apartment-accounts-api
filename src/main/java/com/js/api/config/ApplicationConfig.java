package com.js.api.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {

	@Bean
	@Primary
	public MessageSource messageSource() {
	
		ReloadableResourceBundleMessageSource messages = new ReloadableResourceBundleMessageSource();
		messages.setBasenames("classpath:/i18N/messages");
		messages.setDefaultEncoding("UTF-8");
		return messages;
	}
}
