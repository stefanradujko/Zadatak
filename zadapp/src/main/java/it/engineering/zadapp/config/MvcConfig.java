package it.engineering.zadapp.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import it.engineering.zadapp.formatter.MestoFormatter;

@Configuration
@ComponentScan(basePackages = {
		"it.engineering.zadapp.controller",
		"it.engineering.zadapp.dao",
		"it.engineering.zadapp.service",
		"it.engineering.zadapp.storage",
		"it.engineering.zadapp.formatter",
		"it.engineering.zadapp.status"
})
@EnableWebMvc
@EnableTransactionManagement
public class MvcConfig implements WebMvcConfigurer {
	@Lazy
	@Autowired
	private MestoFormatter mestoFormatter;
	
	public MvcConfig() {
		System.out.println("====MvcConfig()=====");
		
	}
	
	@Bean
	public ViewResolver beanNameViewResolver()
	{
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	@Bean(name = "index")
	public View index()
	{
		JstlView view = new JstlView();
		view.setUrl("index.jsp");
		return view;
	}
	
	@Bean
	public ViewResolver jspViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
		return jpaTransactionManager;
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		return emfb;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(mestoFormatter);
	}
	
	
}

