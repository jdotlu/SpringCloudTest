package org.test.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestService {
	@Autowired
	HelloService helloService;
	
	@RequestMapping("/")
	public String hello() {
		String name = helloService.getFirstName() + " " + helloService.getLastName();
		return "Hello " + name;
	}
}
