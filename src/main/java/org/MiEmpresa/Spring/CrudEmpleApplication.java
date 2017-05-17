package org.MiEmpresa.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@SpringBootApplication
public class CrudEmpleApplication {
	
	 @Bean(name ="templateResolver") 
	 public ServletContextTemplateResolver getTemplateResolver() {
	 ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	 templateResolver.setPrefix("/WEB-INF/view/");
	 templateResolver.setSuffix(".html");
	 templateResolver.setTemplateMode("XHTML");
	 return templateResolver;
	 }
	 
	 @Bean(name ="templateEngine") 
	 public SpringTemplateEngine getTemplateEngine() {
	 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 templateEngine.setTemplateResolver(getTemplateResolver());
	 return templateEngine;
	 }
	 
	 @Bean(name="viewResolver")
	 public ThymeleafViewResolver getViewResolver(){
	 ThymeleafViewResolver viewResolver = new ThymeleafViewResolver(); 
	 viewResolver.setTemplateEngine(getTemplateEngine());
	 return viewResolver;
	 }	  

	public static void main(String[] args) {
		SpringApplication.run(CrudEmpleApplication.class, args);
	}
}
