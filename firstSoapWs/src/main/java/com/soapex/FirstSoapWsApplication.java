package com.soapex;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSoapWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSoapWsApplication.class, args);
	}
	

	
	/**
	 *
	 * Defining a bean like this below is causing a exception at startup:
	 * Parameter 1 of constructor in org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration required a bean of type 
	 * 'org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath' that could not be found.
	-*  Bean method 'dispatcherServletRegistration' not loaded because DispatcherServlet Registration found non dispatcher servlet dispatcherServlet
		Action:
		Consider revisiting the entries above or defining a bean of type 'org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath' in your configuration.
	 * 
	
	@Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }
    
    **/
	
	@Bean
    public ServletRegistrationBean cxfServletRegistration() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }
	
	
    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {      
        return new SpringBus();
    }
    
}
