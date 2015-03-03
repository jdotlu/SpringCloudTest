package org.test.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HelloService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="defaultFirstName")
	public String getFirstName() {
		String firstName = restTemplate.getForObject(
				"http://NameService/firstName", String.class);
		return firstName;
	}
	
	@SuppressWarnings("unused")
	private String defaultFirstName() {
		return "Frank";
	}
	
	@HystrixCommand(fallbackMethod="defaultLastName")
	public String getLastName() {
		String firstName = restTemplate.getForObject(
				"http://NameService/lastName", String.class);
		return firstName;
	}
	
	@SuppressWarnings("unused")
	private String defaultLastName() {
		return "Underwood";
	}
}
