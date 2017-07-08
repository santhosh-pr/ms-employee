package com.ms.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/employee")
@EnableFeignClients
@EnableDiscoveryClient
public class EmployeeController {

    @Value("${yml_file}")
	private String propertyValue;
    
    @Autowired
    DepClient client;
    
    @Autowired
    DiscoveryClient c2;
    
	@RequestMapping(path="/config",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getConfig(){
		return new ResponseEntity<String>("propertyValue "+propertyValue,HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/details",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDetails(){
		
		System.out.println("uri "+c2.getInstances("MS-DEPT-SVC").get(0).getUri());
		
		
		return new ResponseEntity<String>("dept name from  "+client.name(),HttpStatus.OK);
	}
	
	
	@FeignClient("MS-DEPT-SVC")
	interface DepClient {
		@RequestMapping(value = "/api/dept/name", method = RequestMethod.GET)
		String name();
	}
}
