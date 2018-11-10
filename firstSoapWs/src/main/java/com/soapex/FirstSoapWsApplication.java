package com.soapex;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.service.HelloWorldServiceImpl;

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
