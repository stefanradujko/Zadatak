package it.engineering.zadapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class MyWebApplicationInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
			System.out.println("====onStartup====");
			AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
			webContext.register(MvcConfig.class);
			ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
			dispatcher.addMapping("/");
			dispatcher.setLoadOnStartup(1);
			
	}
}
