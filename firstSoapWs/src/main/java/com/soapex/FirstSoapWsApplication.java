package com.soapex;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSoapWsApplication implements CommandLineRunner {

	@Value("${service.port}")
	private String servicePort;

	@Override
	public void run(String... args) throws Exception {
		Endpoint.publish("http://localhost:" + servicePort
				+ "/service/hello-world", new HelloWorldServiceImpl());
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstSoapWsApplication.class, args);
	}
}
