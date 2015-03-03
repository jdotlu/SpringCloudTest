package org.test.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="defaultHello")
	@RequestMapping("/")
	public String hello() {
		String name = restTemplate.getForObject("http://NameService", String.class);
		return "Hello " + name;
	}
	
	public String defaultHello() {
		return "Hello stranger";
	}
}
