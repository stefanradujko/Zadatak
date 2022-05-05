package it.engineering.zadapp.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class RootAppConfig {
	public RootAppConfig() {
		System.out.println("======RootAppConfig=======");
	}
	
	@Bean
	public Validator localValidatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setProviderClass(HibernateValidator.class);
		return bean;
	}
}
