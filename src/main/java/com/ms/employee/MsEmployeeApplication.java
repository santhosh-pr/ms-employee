package com.ms.employee;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsEmployeeApplication {

   @Value("${yml_file}")
   private String propertyValue;
   
   @PostConstruct
	public void init() {
		System.out.println("********* "+propertyValue);
	}
	  
	public static void main(String[] args) {
		SpringApplication.run(MsEmployeeApplication.class, args);
	}
}
